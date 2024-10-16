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
import com.zosh.model.User;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private com.zosh.repository.UserRepository UserRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = UserRepository.findByEmail(username);
        if(user != null){
            throw new UsernameNotFoundException("user not founhd with email" + username);
        }

        USER_ROLE role = user.getRole();
        
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(role.toString()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);

    }


}
