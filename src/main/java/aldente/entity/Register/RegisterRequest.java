package aldente.entity.Register;

import java.io.Serializable;

public class RegisterRequest implements Serializable {

	private static final long serialVersionUID = -1533359700996484156L;

  private boolean register;

	private String username;

	private String email;

	private String password;

	private Boolean registerAsAdmin;

	private String token;

	private String senderId;

  public RegisterRequest() {
  }

  public RegisterRequest(boolean register, String username, String email, String password, Boolean registerAsAdmin, String token, String senderId) {
    this.register = register;
    this.username = username;
    this.email = email;
    this.password = password;
    this.registerAsAdmin = registerAsAdmin;
    this.token = token;
    this.senderId = senderId;
  }

  public boolean isRegister() {
    return register;
  }

  public void setRegister(boolean register) {
    this.register = register;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getRegisterAsAdmin() {
    return registerAsAdmin;
  }

  public void setRegisterAsAdmin(Boolean registerAsAdmin) {
    this.registerAsAdmin = registerAsAdmin;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getSenderId() {
    return senderId;
  }

  public void setSenderId(String senderId) {
    this.senderId = senderId;
  }

  @Override
  public String toString() {
    return "RegisterRequest{" +
      "register=" + register +
      ", username='" + username + '\'' +
      ", email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", registerAsAdmin=" + registerAsAdmin +
      ", token='" + token + '\'' +
      ", senderId='" + senderId + '\'' +
      '}';
  }
}
