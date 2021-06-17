package com.rainie.restservice;

public class NationalizeResponse {

    private String name;
    private Country[] country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country[] getCountry() {
        return country;
    }

    public void setCountry(Country[] country) {
        this.country = country;
    }
}
