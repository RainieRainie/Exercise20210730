package com.rainie.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InformationAPI {

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
 //   APIEntity apiEntity;

    public User getUserInformationAPI (String firstName) {


        User user = new User();
        String ageUrl; String genderUrl; String nationalityUrl;

        ageUrl = "https://api.agify.io?name=" + firstName;
        AgifyResponse quote = restTemplate.getForObject(
                ageUrl, AgifyResponse.class);

        genderUrl = "https://api.genderize.io?name=" + firstName;
        GenderizeResponse quote2 = restTemplate.getForObject(
                genderUrl, GenderizeResponse.class);

        nationalityUrl = "https://api.nationalize.io?name=" + firstName;
        NationalizeResponse quote3 = restTemplate.getForObject(
                nationalityUrl, NationalizeResponse.class);

        int age = quote.getAge();
        String gender = quote2.getGender();
        if (quote3.getCountry() == null) {
      //     return the error msg into user
        }
        else {
        Country[] nationality = quote3.getCountry();
        Country countryID = nationality[0];
        user.setNationality(countryID.getCountry_id());
        }

        user.setFirstName(firstName);
        user.setAge(quote.getAge());
        user.setGender(quote2.getGender());

 /*       private String username;
        private String password;
        private String lastName;
        private String email;
        private String contactNumber;
        private String tags;
        private String status;
*/
/*
//        guess age
        apiEntity = restTemplate.getForObject("https://api.agify.io/?name={?}", APIEntity.class,firstName);
        user.setAge(apiEntity.getAge());

//        guess gender
        apiEntity = restTemplate.getForObject("https://api.genderize.io?name={name}", APIEntity.class, firstName);
        user.setGender(apiEntity.getGender());

//        guess nationality
        apiEntity = restTemplate.getForObject("https://api.nationalize.io?name={name}", APIEntity.class, firstName);
        if (!apiEntity.getCountry().isEmpty()) {
            user.setNationality((String)restTemplate.getForObject("https://api.nationalize.io?name={name}", GuessResEntity.class, firstName).getCountry().get(0).get("country_id"));
        } else {
            user.setNationality(null);
        }
        */




       return  user;
    }

}
