package com.rainie.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user-management")
public class UserManagementController2 {

    @Autowired
    private RestTemplate restTemplate;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private AddUserServiceImpl addUserServiceImpl;

   //     @Autowired
   //     private UpdateUserServiceImpl updateUserServiceImpl;

        @PostMapping("/add")
        @ResponseStatus(HttpStatus.CREATED)
        @ResponseBody
        public void addUser(@RequestBody UserInformationPush userInformationPush) {
            User user = addUserServiceImpl.getUserInfoFull(userInformationPush);
            userRepository.save(user);
        }

    }



