package com.zosh.service;

import com.zosh.model.User;

public interface UserService {

    public User findUserJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;


}
