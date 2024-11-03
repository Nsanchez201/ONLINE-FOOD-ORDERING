package com.zosh.service;

import com.zosh.config.JwtProvider;
import com.zosh.model.User;
import com.zosh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserJwtToken(String jwt) throws Exception {
      String email = jwtProvider.getEmailFromJwtToken(jwt);
      User user = userRepository.findByEmail(email);
      return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {

        User user  = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("User not found");
        }
        return null;
    }
}
