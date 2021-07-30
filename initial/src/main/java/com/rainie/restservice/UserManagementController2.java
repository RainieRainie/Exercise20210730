package com.rainie.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user-management")
public class UserManagementController2 {

    @Autowired
    private RestTemplate restTemplate;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private AddUserServiceImpl addUserServiceImpl;

        @Autowired
        private UpdateUserServiceImpl updateUserServiceImpl;

        //Add
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Map<String, Boolean> addUser(@RequestBody UserInformationPush userInformationPush) {
        User user = addUserServiceImpl.getUserInfoFull(userInformationPush);
        Map<String, Boolean> response = new HashMap<>();
        response.put("{" + user.getUsername() + "}" + " create.", Boolean.TRUE);
        userRepository.save(user);
        return response;
    }

        //Update
    @PutMapping("/user")
    @ResponseBody
    public Map<String, Boolean> updateUser(@RequestBody UserInfoUpdate userInfoUpdate)
            throws UserNotFoundException {
        User user = updateUserServiceImpl.makeUserInfoFull(userInfoUpdate);
        Map<String, Boolean> response = new HashMap<>();
        response.put("{" + user.getUsername() + "}" + " updated.", Boolean.TRUE);
        userRepository.save(user);
        return response;
    }
}



