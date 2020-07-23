package omipos;

import com.couchbase.client.core.error.BucketExistsException;
import com.couchbase.client.core.error.CouchbaseException;
import com.couchbase.client.core.error.DocumentExistsException;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.json.JsonObject;
import omipos.entity.MessageType;
import omipos.entity.Register.RegisterRequest;
import omipos.entity.Register.RegisterResponse;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.async.ResultFuture;
import org.apache.flink.streaming.api.functions.async.RichAsyncFunction;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;


public class AsyncRegisterApiInvocation extends RichAsyncFunction<RegisterRequest, RegisterResponse> {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = LoggerFactory.getLogger(AsyncRegisterApiInvocation.class);
  private final Integer apiTimeoutMs;
  private Bucket bucket;

  /**
   * The Asynchronous client that can issue concurrent requests with callbacks
   */
  private transient AsyncHttpClient asyncHttpClient = null;

  public AsyncRegisterApiInvocation(Integer apiTimeoutMs) {
    this.apiTimeoutMs = apiTimeoutMs;
  }

  @Override
  public void open(Configuration parameters) {
    logger.info("Opening connection " + parameters.toString());
    final Cluster cluster = Cluster.connect("localhost", "master-user", "1234567890");
    bucket = cluster.bucket("user");
    this.asyncHttpClient = new DefaultAsyncHttpClient();
  }

  @Override
  public void close() throws Exception {
    logger.info("Closing connection");
    super.close();
    asyncHttpClient.close();
  }

  @Override
  public void timeout(RegisterRequest registerRequest, ResultFuture<RegisterResponse> resultFuture) throws Exception {
    RegisterResponse registerResponse = new RegisterResponse();
    registerResponse.setSuccess(false);
    registerResponse.setSenderId(registerRequest.getSenderId());
    registerResponse.setError("[TimeoutException Api-Invocation]");
    registerResponse.setCause("Timeout occurred during registration");
    resultFuture.complete(Collections.singletonList(registerResponse));
  }

  @Override
  public void asyncInvoke(RegisterRequest registerRequest, final ResultFuture<RegisterResponse> resultFuture) throws Exception {
    // issue the asynchronous request, receive a future for result
    RegisterResponse responseMessage = new RegisterResponse();
    responseMessage.setSenderId(registerRequest.getSenderId());

    try {
      if (registerRequest.isRegister()) {
        JsonObject jsonObject = JsonObject.create();
        jsonObject.put("username", registerRequest.getUsername());
        jsonObject.put("email", registerRequest.getEmail());
        jsonObject.put("password", registerRequest.getPassword());
        jsonObject.put("registerAsAdmin", registerRequest.getRegisterAsAdmin());
        jsonObject.put("senderId", registerRequest.getSenderId());
        bucket.defaultCollection().insert(registerRequest.getUsername(), jsonObject);

        responseMessage.setSuccess(true);
        responseMessage.setData(registerRequest);
        responseMessage.setMessageType(MessageType.REST);
        responseMessage.setMessageType(MessageType.REST);
        resultFuture.complete(Collections.singletonList(responseMessage));
      } else {
        RegisterRequest document = bucket.defaultCollection().get(registerRequest.getUsername()).contentAs(RegisterRequest.class);
        if (document.getPassword().equals(registerRequest.getPassword())) {
          RegisterRequest resultRequest = new RegisterRequest();
          resultRequest.setEmail(document.getEmail());
          resultRequest.setUsername(document.getUsername());
          resultRequest.setRegisterAsAdmin(document.getRegisterAsAdmin());
          resultRequest.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");

          responseMessage.setSuccess(true);
          responseMessage.setData(resultRequest);
          responseMessage.setMessageType(MessageType.REST);
          responseMessage.setMessageType(MessageType.REST);
          resultFuture.complete(Collections.singletonList(responseMessage));
        } else {
          responseMessage.setSenderId(registerRequest.getSenderId());
          responseMessage.setSuccess(false);
          responseMessage.setError("Invalid Credentials");
          responseMessage.setCause("You has miss match enter a credentials");
          resultFuture.complete(Collections.singletonList(responseMessage));
        }
      }
    } catch (DocumentExistsException ce) {
      responseMessage.setSenderId(registerRequest.getSenderId());
      responseMessage.setSuccess(false);
      responseMessage.setError("Data exist");
      responseMessage.setCause(ce.getMessage());
      resultFuture.complete(Collections.singletonList(responseMessage));
      logger.error("Exception Couchbase " + ce);
    } catch (Exception ex) {
      logger.error("Exception [HTTP] Client " + ex);
    }
  }


}
