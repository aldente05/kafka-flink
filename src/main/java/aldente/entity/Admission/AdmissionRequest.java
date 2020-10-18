package aldente.entity.Admission;

import aldente.entity.Admission.elements.DetailLimit;
import aldente.entity.Admission.elements.Eligibility;
import aldente.entity.Admission.elements.LifeAssured;
import aldente.entity.Admission.elements.PolicyHolder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by f.putra on 7/22/20.
 */
public class AdmissionRequest implements Serializable {

  private static final long serialVersionUID = 8284775206074868834L;

  private String inquiry;
  private String riderCode;
  private String riderStatusCode;
  private String policyStatusCode;
  private String policyNo;
  private String lifeNo;
  private String coverageNo;
  private String riderNo;
  private String dailyLimit;
  private String name;
  private Integer age;
  private String claimType;
  private String clientId;
  private String dateLimit;
  private String riderName;
  private String productName;
  private String clientNumber;
  private String firstdate;
  private String tpaCode;
  private PolicyHolder policyHolder;
  private LifeAssured lifeAssured;
  private List<DetailLimit> detailLimit = null;
  private Eligibility eligibility;
  private Boolean isPPHPlus;
  private String agentCode;
  private String senderId;

  /**
   * No args constructor for use in serialization
   */
  public AdmissionRequest() {
  }

  public AdmissionRequest(String inquiry, String riderCode, String riderStatusCode, String policyStatusCode, String policyNo, String lifeNo, String coverageNo, String riderNo, String dailyLimit, String name, Integer age, String claimType, String clientId, String dateLimit, String riderName, String productName, String clientNumber, String firstdate, String tpaCode, PolicyHolder policyHolder, LifeAssured lifeAssured, List<DetailLimit> detailLimit, Eligibility eligibility, Boolean isPPHPlus, String agentCode, String senderId) {
    this.inquiry = inquiry;
    this.riderCode = riderCode;
    this.riderStatusCode = riderStatusCode;
    this.policyStatusCode = policyStatusCode;
    this.policyNo = policyNo;
    this.lifeNo = lifeNo;
    this.coverageNo = coverageNo;
    this.riderNo = riderNo;
    this.dailyLimit = dailyLimit;
    this.name = name;
    this.age = age;
    this.claimType = claimType;
    this.clientId = clientId;
    this.dateLimit = dateLimit;
    this.riderName = riderName;
    this.productName = productName;
    this.clientNumber = clientNumber;
    this.firstdate = firstdate;
    this.tpaCode = tpaCode;
    this.policyHolder = policyHolder;
    this.lifeAssured = lifeAssured;
    this.detailLimit = detailLimit;
    this.eligibility = eligibility;
    this.isPPHPlus = isPPHPlus;
    this.agentCode = agentCode;
    this.senderId = senderId;
  }

  public String getInquiry() {
    return inquiry;
  }

  public void setInquiry(String inquiry) {
    this.inquiry = inquiry;
  }

  public String getRiderCode() {
    return riderCode;
  }

  public void setRiderCode(String riderCode) {
    this.riderCode = riderCode;
  }

  public String getRiderStatusCode() {
    return riderStatusCode;
  }

  public void setRiderStatusCode(String riderStatusCode) {
    this.riderStatusCode = riderStatusCode;
  }

  public String getPolicyStatusCode() {
    return policyStatusCode;
  }

  public void setPolicyStatusCode(String policyStatusCode) {
    this.policyStatusCode = policyStatusCode;
  }

  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }

  public String getLifeNo() {
    return lifeNo;
  }

  public void setLifeNo(String lifeNo) {
    this.lifeNo = lifeNo;
  }

  public String getCoverageNo() {
    return coverageNo;
  }

  public void setCoverageNo(String coverageNo) {
    this.coverageNo = coverageNo;
  }

  public String getRiderNo() {
    return riderNo;
  }

  public void setRiderNo(String riderNo) {
    this.riderNo = riderNo;
  }

  public String getDailyLimit() {
    return dailyLimit;
  }

  public void setDailyLimit(String dailyLimit) {
    this.dailyLimit = dailyLimit;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getClaimType() {
    return claimType;
  }

  public void setClaimType(String claimType) {
    this.claimType = claimType;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getDateLimit() {
    return dateLimit;
  }

  public void setDateLimit(String dateLimit) {
    this.dateLimit = dateLimit;
  }

  public String getRiderName() {
    return riderName;
  }

  public void setRiderName(String riderName) {
    this.riderName = riderName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getClientNumber() {
    return clientNumber;
  }

  public void setClientNumber(String clientNumber) {
    this.clientNumber = clientNumber;
  }

  public String getFirstdate() {
    return firstdate;
  }

  public void setFirstdate(String firstdate) {
    this.firstdate = firstdate;
  }

  public String getTpaCode() {
    return tpaCode;
  }

  public void setTpaCode(String tpaCode) {
    this.tpaCode = tpaCode;
  }

  public PolicyHolder getPolicyHolder() {
    return policyHolder;
  }

  public void setPolicyHolder(PolicyHolder policyHolder) {
    this.policyHolder = policyHolder;
  }

  public LifeAssured getLifeAssured() {
    return lifeAssured;
  }

  public void setLifeAssured(LifeAssured lifeAssured) {
    this.lifeAssured = lifeAssured;
  }

  public List<DetailLimit> getDetailLimit() {
    return detailLimit;
  }

  public void setDetailLimit(List<DetailLimit> detailLimit) {
    this.detailLimit = detailLimit;
  }

  public Eligibility getEligibility() {
    return eligibility;
  }

  public void setEligibility(Eligibility eligibility) {
    this.eligibility = eligibility;
  }

  public Boolean getPPHPlus() {
    return isPPHPlus;
  }

  public void setPPHPlus(Boolean PPHPlus) {
    isPPHPlus = PPHPlus;
  }

  public String getAgentCode() {
    return agentCode;
  }

  public void setAgentCode(String agentCode) {
    this.agentCode = agentCode;
  }

  public String getSenderId() {
    return senderId;
  }

  public void setSenderId(String senderId) {
    this.senderId = senderId;
  }

  @Override
  public String toString() {
    return "AdmissionRequest{" +
      "inquiry='" + inquiry + '\'' +
      ", riderCode='" + riderCode + '\'' +
      ", riderStatusCode='" + riderStatusCode + '\'' +
      ", policyStatusCode='" + policyStatusCode + '\'' +
      ", policyNo='" + policyNo + '\'' +
      ", lifeNo='" + lifeNo + '\'' +
      ", coverageNo='" + coverageNo + '\'' +
      ", riderNo='" + riderNo + '\'' +
      ", dailyLimit='" + dailyLimit + '\'' +
      ", name='" + name + '\'' +
      ", age=" + age +
      ", claimType='" + claimType + '\'' +
      ", clientId='" + clientId + '\'' +
      ", dateLimit='" + dateLimit + '\'' +
      ", riderName='" + riderName + '\'' +
      ", productName='" + productName + '\'' +
      ", clientNumber='" + clientNumber + '\'' +
      ", firstdate='" + firstdate + '\'' +
      ", tpaCode='" + tpaCode + '\'' +
      ", policyHolder=" + policyHolder +
      ", lifeAssured=" + lifeAssured +
      ", detailLimit=" + detailLimit +
      ", eligibility=" + eligibility +
      ", isPPHPlus=" + isPPHPlus +
      ", agentCode='" + agentCode + '\'' +
      ", senderId='" + senderId + '\'' +
      '}';
  }
}
