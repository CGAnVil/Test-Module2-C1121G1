package com.company.Model;

import java.io.Serializable;

public class PhoneContact implements Serializable {
    private String contactNumber;
    private String contactType;
    private String contactName;
    private String contactGender;
    private String contactAddress;
    private String contactDOB;
    private String contactEmail;

    public PhoneContact() {
    }

    public PhoneContact (String contactNumber, String contactType, String contactName, String contactGender, String contactAddress, String contactDOB, String contactEmail) {
        this.contactNumber = contactNumber;
        this.contactType = contactType;
        this.contactName = contactName;
        this.contactGender = contactGender;
        this.contactAddress = contactAddress;
        this.contactDOB = contactDOB;
        this.contactEmail = contactEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactGender() {
        return contactGender;
    }

    public void setContactGender(String contactGender) {
        this.contactGender = contactGender;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactDOB() {
        return contactDOB;
    }

    public void setContactDOB(String contactDOB) {
        this.contactDOB = contactDOB;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return
                "Số điện thoại:'" + contactNumber + '\'' +
                ", contactType:'" + contactType + '\'' +
                ", contactName:'" + contactName + '\'' +
                ", contactGender:'" + contactGender + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", contactDOB='" + contactDOB + '\'' +
                ", contactEmail='" + contactEmail + '\'' ;
    }
}
