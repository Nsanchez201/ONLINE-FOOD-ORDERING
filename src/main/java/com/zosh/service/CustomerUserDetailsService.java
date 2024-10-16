package com.zosh.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository UserRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = UserRepository.findByEmail(username);
        if(user != null){
            throw new UsernameNotFoundException("user not founhd with email" + username);
        }

        USER_ROLE role = user.getRole();
        
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(role.toString()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword,authorities)

    }


}
