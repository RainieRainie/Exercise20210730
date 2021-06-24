package com.rainie.restservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserManagementController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/api/user-management/user/{user}")

    public UserResponse UserMgmt(@PathVariable String user){
        String ageUrl; String genderUrl; String nationalityUrl;
        ageUrl = "https://api.agify.io?name=" + user;
        AgifyResponse quote = restTemplate.getForObject(
                ageUrl, AgifyResponse.class);

        genderUrl = "https://api.genderize.io?name=" + user;
        GenderizeResponse quote2 = restTemplate.getForObject(
                genderUrl, GenderizeResponse.class);

        nationalityUrl = "https://api.nationalize.io?name=" + user;
        NationalizeResponse quote3 = restTemplate.getForObject(
                nationalityUrl, NationalizeResponse.class);

        int age = quote.getAge();
        String gender = quote2.getGender();
       Country[] nationality = quote3.getCountry();
        Country countryID = nationality[0];

        UserResponse userOutput = new UserResponse(user, age, gender, countryID.getCountry_id());
        userOutput.setName(user);
        userOutput.setAge(age);
        userOutput.setGender(gender);
        userOutput.setNationality(countryID.getCountry_id());


       // return userOutput;
        return  userOutput;
 //        UserResponse output = buildUserMgmt(user, quote, quote2, quote3);
   //     return output;
    }

//    public UserMgmt buildUserMgmt(@RequestBody String user, UserDetail content, UserDetail2 content2, UserDetail3 content3) {
//        ArrayList list = new ArrayList();
//        int age = content.getAge();
//        String gender = content2.getGender();
//        Country[] nationality = content3.getCountry();
//        UserMgmt userOutput = new UserMgmt();
//        userOutput.setAge(age);
//        return userOutput;
}

//}
