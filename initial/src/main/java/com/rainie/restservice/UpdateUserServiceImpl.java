package com.rainie.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InformationGenerator informationGenerator;


    @Override
    public User makeUserInfoFull(UserInfoUpdate userInfoUpdate)
            throws UserNotFoundException {
        User user_to_update =
                userRepository.findById(userInfoUpdate.getUsername())
                        .orElseThrow(() -> new UserNotFoundException("User not found by this username : " + "{" + userInfoUpdate.getUsername() + "}"));
        User user_guess = new User();
        User user = new User();

//        first name change, guess information update
        // Rylie: check if the user_to_update is the input update username???????
        Boolean firstName_new = (user_to_update.getFirstName() != userInfoUpdate.getFirstName() && userInfoUpdate.getFirstName() != null);
        if (firstName_new)
        {
            user.setUsername(user_to_update.getUsername());
            user.setAge(userInfoUpdate.getAge());
            user.setContactNumber(userInfoUpdate.getLastName() );
            user.setEmail(userInfoUpdate.getEmail());
            user.setFirstName(userInfoUpdate.getFirstName());
            user.setGender(userInfoUpdate.getGender());
            user.setLastName(userInfoUpdate.getLastName());
            user.setNationality(userInfoUpdate.getNationality());
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

