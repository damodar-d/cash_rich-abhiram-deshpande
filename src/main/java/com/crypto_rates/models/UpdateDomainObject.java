package com.crypto_rates.models;

public class UpdateDomainObject {

    private String username;
    private String updatedValue;

    public UpdateDomainObject(String username, String updatedValue) {
        this.username = username;
        this.updatedValue = updatedValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpdatedValue() {
        return updatedValue;
    }

    public void setUpdatedValue(String updatedValue) {
        this.updatedValue = updatedValue;
    }
}
