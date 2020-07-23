
package omipos.entity.Admission.elements;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class Eligibility {

    private Boolean annualLimitAvailable;

    /**
     * No args constructor for use in serialization
     *
     */
    public Eligibility() {
    }

    /**
     *
     * @param annualLimitAvailable
     */
    public Eligibility(Boolean annualLimitAvailable) {
        super();
        this.annualLimitAvailable = annualLimitAvailable;
    }

    @JsonProperty("annualLimitAvailable")
    public Boolean getAnnualLimitAvailable() {
        return annualLimitAvailable;
    }

    @JsonProperty("annualLimitAvailable")
    public void setAnnualLimitAvailable(Boolean annualLimitAvailable) {
        this.annualLimitAvailable = annualLimitAvailable;
    }

}
