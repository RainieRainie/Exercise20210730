package com.rainie.restservice;

public class UserResponse {

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

    public UserResponse(String name, int age, String gender, String countryID) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.countryID = countryID;
    }

  /*  public UserResponse buildUserMgmt(String user, UserDetail content, UserDetail2 content2, UserDetail3 content3) {
        int age = content.getAge();
        String gender = content2.getGender();
        Country[] nationality = content3.getCountry();
        UserResponse userOutput = new UserResponse();
        userOutput.setAge(age);
        return userOutput;
    } */
}
