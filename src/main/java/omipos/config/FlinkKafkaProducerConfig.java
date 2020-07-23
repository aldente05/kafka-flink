package omipos.config;

import java.util.Properties;

public class FlinkKafkaProducerConfig {

	/**
	 * Generate the properties for the kafka consumer
	 */
	public static Properties getKafkaProduerConfig(String topic, String group) {
		Properties prop = new Properties();
		prop.setProperty("topic", topic);
		prop.setProperty("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
		prop.setProperty("zookeeper.connect", "localhost:2181");
		prop.setProperty("group.id", group);
		prop.setProperty("enable.auto.commit", "true");
		return prop;

	}
}
