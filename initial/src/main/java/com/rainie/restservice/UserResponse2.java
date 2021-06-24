package com.rainie.restservice;

public class UserResponse2 {

    private String name;
    private int age;
    private String gender;
    private String countryID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return countryID;
    }

    public void setNationality(String countryID) {
        this.countryID = countryID;
    }

    public UserResponse2(String name, int age, String gender, String countryID) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.countryID = countryID;
    }

}
