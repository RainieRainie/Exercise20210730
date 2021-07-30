package com.rainie.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class AddUserServiceImpl extends Throwable implements AddUserService {


    @Autowired
    private InformationGenerator informationGenerator;

    @Autowired
    private InformationAPI informationAPI;

//    @Autowired
//    private UserInfoGuess userInfoGuess;

//    @Autowired
//    private UserInfoGen userInfoGen;
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
@ResponseBody
public void addUser(@RequestBody UserInformationPush userInformationPush) {
    User user_to_add = getUserInfoFull(userInformationPush);

}
    @Override
    public User getUserInfoFull(UserInformationPush userInformationPush) {

        User user_gen = informationGenerator.getUserInformationGenerator(userInformationPush);
        User user_api = informationAPI.getUserInformationAPI(userInformationPush.getFirstName());

        User user = new User();
        user.setUsername(user_gen.getUsername());
        user.setAge(user_api.getAge());
        user.setContactNumber(userInformationPush.getContactNumber());
        user.setEmail(userInformationPush.getEmail());
        user.setFirstName(user_api.getFirstName());
        user.setGender(user_api.getGender());
        user.setLastName(userInformationPush.getLastName());
        user.setNationality(user_api.getNationality());
        user.setPassword(userInformationPush.getPassword());
        user.setStatus(user_gen.getStatus());
   //     user.setCreated(user_gen.getCreated());
        user.setCreated(InformationGenerator.getStringDate());
        user.setUpdated(user_gen.getUpdated());
        user.setTags(user_gen.getTags());

       return user;
    }
}
