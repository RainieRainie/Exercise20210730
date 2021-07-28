package com.rainie.restservice;

public interface UpdateUserService {
    public User makeUserInfoFull(UserInfoUpdate userInfoUpdate) throws UserNotFoundException;
}
