package com.rainie.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InformationGenerator informationGenerator;

    @Autowired
    private InformationAPI informationAPI;


    @Override
    public User makeUserInfoFull(UserInfoUpdate userInfoUpdate)
            throws UserNotFoundException {
   // Use the email as the username
        User user_to_update =
                userRepository.findById(userInfoUpdate.getEmail())
                        .orElseThrow(() -> new UserNotFoundException("User not found by this username : " + "{" + userInfoUpdate.getUsername() + "}"));
   //     User user_guess = new User();
        User user = new User();
        User user_api = informationAPI.getUserInformationAPI(userInfoUpdate.getFirstName());
//        first name change, guess information update
        // Rylie: check if the user_to_update is the input update username???????
        Boolean firstName_new = (user_to_update.getFirstName() != userInfoUpdate.getFirstName() && userInfoUpdate.getFirstName() != null);
        if (firstName_new)
        {
        //    user.setUsername(user_to_update.getUsername());
            user.setUsername(user_to_update.getEmail());
     //       user.setAge(userInfoUpdate.getAge());
            user.setAge(user_api.getAge());
            user.setContactNumber(userInfoUpdate.getContactNumber());
            user.setEmail(userInfoUpdate.getEmail());
            user.setFirstName(userInfoUpdate.getFirstName());
    //        user.setGender(userInfoUpdate.getGender());
            user.setGender(user_api.getGender());
            user.setLastName(userInfoUpdate.getLastName());
    //        user.setNationality(userInfoUpdate.getNationality());
            user.setNationality(user_api.getNationality());
            user.setPassword(userInfoUpdate.getPassword());
            user.setStatus("active");
            user.setCreated(user_to_update.getCreated());
            user.setUpdated(InformationGenerator.getStringDate());
            user.setTags(userInfoUpdate.getTags() != null ? userInfoUpdate.getTags() : user_to_update.getTags());
            user.setStatus("active");
        };
        return user;
    }
}

