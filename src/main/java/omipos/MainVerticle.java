package omipos;

import omipos.config.FlinkKafkaConsumerConfig;
import omipos.config.FlinkKafkaProducerConfig;
import omipos.entity.Admission.AdmissionRequest;
import omipos.entity.Admission.AdmissionRequestSchema;
import omipos.entity.Admission.AdmissionResponse;
import omipos.entity.Admission.AdmissionResponseSerializer;
import omipos.entity.Register.RegisterRequest;
import omipos.entity.Register.RegisterRequestSchema;
import omipos.entity.Register.RegisterResponse;
import omipos.entity.Register.RegisterResponseSerializer;
import org.apache.flink.streaming.api.datastream.AsyncDataStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.async.AsyncFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MainVerticle {

  private static final Logger logger = LoggerFactory.getLogger(MainVerticle.class);

  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    Properties consumerPropRegister = FlinkKafkaConsumerConfig.getKafkaConsumerConfig("register", "flink-auth-group");
    Properties consumerPropAdmission = FlinkKafkaConsumerConfig.getKafkaConsumerConfig("admission", "flink-admission-group");

    // Create a flink consumer from the topic with a custom serializer for "Model Request"
    FlinkKafkaConsumer010<RegisterRequest> consumerRegister = new FlinkKafkaConsumer010<>(consumerPropRegister.getProperty("topic"), new RegisterRequestSchema(), consumerPropRegister);
    FlinkKafkaConsumer010<AdmissionRequest> consumerAdmission = new FlinkKafkaConsumer010<>(consumerPropAdmission.getProperty("topic"), new AdmissionRequestSchema(), consumerPropAdmission);

    // Start reading partitions from the consumer group’s committed offsets in Kafka brokers
    consumerRegister.setStartFromGroupOffsets();
    consumerAdmission.setStartFromGroupOffsets();

    // Create a flink data stream from the consumer source i.e Kafka topic
    DataStream<RegisterRequest> messageStreamRegister = env.addSource(consumerRegister);
    DataStream<AdmissionRequest> messageStreamAdmission = env.addSource(consumerAdmission);

    logger.info(String.valueOf(messageStreamRegister.process(new ProcessFunction<RegisterRequest, Object>() {
      @Override
      public void processElement(RegisterRequest RegisterRequest, Context context, Collector<Object> collector) throws Exception {
        logger.info("Processing incoming request " + RegisterRequest);
      }
    })));

    logger.info(String.valueOf(messageStreamAdmission.process(new ProcessFunction<AdmissionRequest, Object>() {
      @Override
      public void processElement(AdmissionRequest admissionRequest, Context context, Collector<Object> collector) throws Exception {
        logger.info("Processing incoming request " + admissionRequest);
      }
    })));

    //Set default timeout for the api. Ideally this should be fetched from a config server
    Integer apiTimeoutMs = 10000;

    //Function that defines how a datastream object would be transformed from within flink
    AsyncFunction<RegisterRequest, RegisterResponse> loginRestTransform =
      new AsyncRegisterApiInvocation(apiTimeoutMs);

    AsyncFunction<AdmissionRequest, AdmissionResponse> admissionRestTransform =
      new AsyncAdmissionApiInvocation(apiTimeoutMs);

    //Transform the datastream in parallel
    DataStream<RegisterResponse> resultRegister = AsyncDataStream
      .unorderedWait(messageStreamRegister, loginRestTransform, apiTimeoutMs, TimeUnit.MILLISECONDS, 1)
      .setParallelism(1);

    DataStream<AdmissionResponse> resultAdmission = AsyncDataStream
      .unorderedWait(messageStreamAdmission, admissionRestTransform, apiTimeoutMs, TimeUnit.MILLISECONDS, 1)
      .setParallelism(1);

    Properties producerPropRegister = FlinkKafkaProducerConfig.getKafkaProduerConfig("auth-resp", "flink-auth-group");
    Properties producerPropAdmission = FlinkKafkaProducerConfig.getKafkaProduerConfig("admission-resp", "flink-admission-group");

    //Write the result back to the Kafka sink i.e response topic
    resultRegister.addSink(new FlinkKafkaProducer010<>(producerPropRegister.getProperty("topic"), new RegisterResponseSerializer(),
      producerPropRegister));

    resultAdmission.addSink(new FlinkKafkaProducer010<>(producerPropAdmission.getProperty("topic"), new AdmissionResponseSerializer(),
      producerPropAdmission));
    env.execute();
  }
}
