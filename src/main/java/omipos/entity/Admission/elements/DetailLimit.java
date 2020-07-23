
package omipos.entity.Admission.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailLimit {

    private String policyNo;
    private String tranNo;
    private String polisRiderCode;
    private String dateFrom;
    private String dateEnd;
    private String limitCancer;
    private String limitEmergency;
    private String limitKidney;
    private String plan;
    private String bed;
    private String planCode;

    /**
     * No args constructor for use in serialization
     *
     */
    public DetailLimit() {
    }

    /**
     *
     * @param limitCancer
     * @param bed
     * @param limitEmergency
     * @param limitKidney
     * @param policyNo
     * @param tranNo
     * @param polisRiderCode
     * @param dateEnd
     * @param dateFrom
     * @param plan
     * @param planCode
     */
    public DetailLimit(String policyNo, String tranNo, String polisRiderCode, String dateFrom, String dateEnd, String limitCancer, String limitEmergency, String limitKidney, String plan, String bed, String planCode) {
        super();
        this.policyNo = policyNo;
        this.tranNo = tranNo;
        this.polisRiderCode = polisRiderCode;
        this.dateFrom = dateFrom;
        this.dateEnd = dateEnd;
        this.limitCancer = limitCancer;
        this.limitEmergency = limitEmergency;
        this.limitKidney = limitKidney;
        this.plan = plan;
        this.bed = bed;
        this.planCode = planCode;
    }

    @JsonProperty("policyNo")
    public String getPolicyNo() {
        return policyNo;
    }

    @JsonProperty("policyNo")
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    @JsonProperty("tranNo")
    public String getTranNo() {
        return tranNo;
    }

    @JsonProperty("tranNo")
    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    @JsonProperty("polisRiderCode")
    public String getPolisRiderCode() {
        return polisRiderCode;
    }

    @JsonProperty("polisRiderCode")
    public void setPolisRiderCode(String polisRiderCode) {
        this.polisRiderCode = polisRiderCode;
    }

    @JsonProperty("dateFrom")
    public String getDateFrom() {
        return dateFrom;
    }

    @JsonProperty("dateFrom")
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    @JsonProperty("dateEnd")
    public String getDateEnd() {
        return dateEnd;
    }

    @JsonProperty("dateEnd")
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @JsonProperty("limitCancer")
    public String getLimitCancer() {
        return limitCancer;
    }

    @JsonProperty("limitCancer")
    public void setLimitCancer(String limitCancer) {
        this.limitCancer = limitCancer;
    }

    @JsonProperty("limitEmergency")
    public String getLimitEmergency() {
        return limitEmergency;
    }

    @JsonProperty("limitEmergency")
    public void setLimitEmergency(String limitEmergency) {
        this.limitEmergency = limitEmergency;
    }

    @JsonProperty("limitKidney")
    public String getLimitKidney() {
        return limitKidney;
    }

    @JsonProperty("limitKidney")
    public void setLimitKidney(String limitKidney) {
        this.limitKidney = limitKidney;
    }

    @JsonProperty("plan")
    public String getPlan() {
        return plan;
    }

    @JsonProperty("plan")
    public void setPlan(String plan) {
        this.plan = plan;
    }

    @JsonProperty("bed")
    public String getBed() {
        return bed;
    }

    @JsonProperty("bed")
    public void setBed(String bed) {
        this.bed = bed;
    }

    @JsonProperty("planCode")
    public String getPlanCode() {
        return planCode;
    }

    @JsonProperty("planCode")
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

}
