
package omipos.entity.Admission.elements;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class LifeAssured {

    private String stateId;
    private String dateOfBirth;
    private String placeOfBirth;
    private String gender;
    private String surname;
    private String address;
    private String contactNo;
    private String clientId;

    /**
     * No args constructor for use in serialization
     *
     */
    public LifeAssured() {
    }

    /**
     *
     * @param placeOfBirth
     * @param address
     * @param clientId
     * @param gender
     * @param surname
     * @param stateId
     * @param dateOfBirth
     * @param contactNo
     */
    public LifeAssured(String stateId, String dateOfBirth, String placeOfBirth, String gender, String surname, String address, String contactNo, String clientId) {
        super();
        this.stateId = stateId;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
        this.surname = surname;
        this.address = address;
        this.contactNo = contactNo;
        this.clientId = clientId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

}
