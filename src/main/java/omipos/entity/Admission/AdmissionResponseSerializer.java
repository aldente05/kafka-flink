package omipos.entity.Admission;

import com.google.gson.Gson;
import org.apache.flink.api.common.serialization.SerializationSchema;

/**
 * Created by f.putra on 7/22/20.
 */
public class AdmissionResponseSerializer implements SerializationSchema<AdmissionResponse> {

  private static final long serialVersionUID = 6154188370181669751L;

  @Override
  public byte[] serialize(AdmissionResponse admissionResponse) {
    Gson g = new Gson();
    String message = g.toJson(admissionResponse);
    return message.getBytes();
  }
}
