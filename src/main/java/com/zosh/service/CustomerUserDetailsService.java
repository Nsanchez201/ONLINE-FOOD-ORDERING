package com.zosh.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zosh.model.USER_ROLE;
import com.zosh.model.Users;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private com.zosh.repository.UserRepository UserRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users users = UserRepository.findByEmail(username);
        if(users == null){
            throw new UsernameNotFoundException("users not founhd with email" + username);
        }

        USER_ROLE role = users.getRole();
        
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(role.toString()));

        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(),authorities);

    }


}
