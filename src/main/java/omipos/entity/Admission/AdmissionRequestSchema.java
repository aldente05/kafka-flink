package omipos.entity.Admission;

import com.google.gson.Gson;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;

import java.io.IOException;

/**
 * Created by f.putra on 7/22/20.
 */
public class AdmissionRequestSchema implements DeserializationSchema<AdmissionRequest>,
  SerializationSchema<AdmissionRequest> {

  private static final long serialVersionUID = 6154188370181669711L;

  public TypeInformation<AdmissionRequest> getProducedType() {
    return TypeExtractor.getForClass(AdmissionRequest.class);
  }


  public byte[] serialize(AdmissionRequest element) {
    Gson g = new Gson();
    String message = g.toJson(element);
    return message.getBytes();
  }


  public AdmissionRequest deserialize(byte[] message) throws IOException {
    String strMessage = new String(message);
    return new Gson().fromJson(strMessage, AdmissionRequest.class);
  }


  public boolean isEndOfStream(AdmissionRequest nextElement) {
    return false;
  }
}
