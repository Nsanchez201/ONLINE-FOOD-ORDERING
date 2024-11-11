package com.zosh.controller;


import com.zosh.model.Users;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<Users> findUserByJwtToken(@RequestHeader("Authorization") String jwt) throws Exception {
        Users users = userService.findUserJwtToken(jwt);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
