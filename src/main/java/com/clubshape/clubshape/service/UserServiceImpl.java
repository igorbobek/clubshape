package com.clubshape.clubshape.service;

import com.clubshape.clubshape.entity.User;
import com.clubshape.clubshape.repository.RoleRepository;
import com.clubshape.clubshape.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void save(User user) {
        user.getRoles().add(roleRepository.findByRole("USER"));
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
