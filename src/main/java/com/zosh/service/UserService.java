package com.zosh.service;

import com.zosh.model.Users;

public interface UserService {

    public Users findUserJwtToken(String jwt) throws Exception;

    public Users findUserByEmail(String email) throws Exception;


}
