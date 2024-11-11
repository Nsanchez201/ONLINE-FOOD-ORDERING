package com.zosh.service;

import com.zosh.config.JwtProvider;
import com.zosh.model.Users;
import com.zosh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public Users findUserJwtToken(String jwt) throws Exception {
      String email = jwtProvider.getEmailFromJwtToken(jwt);
      Users users = userRepository.findByEmail(email);
      return users;
    }

    @Override
    public Users findUserByEmail(String email) throws Exception {

        Users users = userRepository.findByEmail(email);

        if (users == null) {
            throw new Exception("Users not found");
        }
        return null;
    }
}
