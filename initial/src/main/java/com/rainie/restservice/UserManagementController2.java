package com.rainie.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        @PutMapping("/add")
        @ResponseStatus(HttpStatus.CREATED)
        @ResponseBody
        public void addUser(@RequestBody UserInformationPush userInformationPush) {
            User user = addUserServiceImpl.getUserInfoFull(userInformationPush);
            userRepository.save(user);
        }
    @PostMapping("/update")
    @ResponseBody
    public Map<String, Boolean> updateUser(@RequestBody UserInfoUpdate userInfoUpdate)
            throws UserNotFoundException {
        User user_to_update =
                userRepository
                        .findById(userInfoUpdate.getUsername())
                        .orElseThrow(() -> new UserNotFoundException("User not found by this username : " + "{" + userInfoUpdate.getUsername() + "}"));
        User user = updateUserServiceImpl.makeUserInfoFull(userInfoUpdate);
        Map<String, Boolean> response = new HashMap<>();
        response.put("{" + user_to_update.getUsername() + "}" + " updated.", Boolean.TRUE);
        userRepository.save(user);
        return response;
    }
}



