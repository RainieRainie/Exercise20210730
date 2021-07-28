package com.rainie.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserServiceImpl implements AddUserService {


    @Autowired
    private InformationGenerator informationGenerator;

    @Autowired
    private InformationAPI informationAPI;

//    @Autowired
//    private UserInfoGuess userInfoGuess;

//    @Autowired
//    private UserInfoGen userInfoGen;

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
        user.setCreated(user_gen.getCreated());
        user.setUpdated(user_gen.getUpdated());
        user.setTags(user_gen.getTags());

       return user;
    }
}
