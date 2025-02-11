package com.example.Restaurant.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public class Client {
    @NotNull
    private Integer id;           

    @NotBlank
    private String lastname;
    
    @NotBlank
    private String firstname;   

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;    

    @NotBlank
    private String gender; 

    private Boolean isVIP;       

    public Client() {}


    public Client(Integer id, String lastname, String firstname, String email, String phoneNumber, String gender, Boolean isVIP) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.isVIP = isVIP;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean isIsVIP() {
        return this.isVIP;
    }

    public Boolean getIsVIP() {
        return this.isVIP;
    }

    public void setIsVIP(Boolean isVIP) {
        this.isVIP = isVIP;
    }


}

