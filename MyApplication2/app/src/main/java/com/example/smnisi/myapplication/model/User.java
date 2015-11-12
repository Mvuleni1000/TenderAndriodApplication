package com.example.smnisi.myapplication.model;

/**
 * Created by smnisi on 2015/09/25.
 */
public class User {

    private Long userID;
    private String contactDetails;
    private String account;
    private String company;
    private String address;
    private String name;
    private String surname;
    private String userIDs;


    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUserIDs(String userIDs) {
        this.userIDs = userIDs;
    }

    public Long getUserID() {
        return userID;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public String getAccount() {
        return account;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUserIDs() {
        return userIDs;
    }


}

