package com.clubshape.clubshape.service;

import com.clubshape.clubshape.entity.User;
import com.clubshape.clubshape.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User activeUserInfo = userRepository.findByName(userName);
        List<GrantedAuthority> listOfAuthority = new ArrayList<>();
        activeUserInfo.getRoles().forEach(role -> listOfAuthority.add(new SimpleGrantedAuthority("ROLE_" + role.getRole())));
        UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(activeUserInfo.getName(),
                activeUserInfo.getPassword(), listOfAuthority);
        return userDetails;
    }

}
