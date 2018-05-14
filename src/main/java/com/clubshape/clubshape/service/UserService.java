package com.clubshape.clubshape.service;

import com.clubshape.clubshape.entity.User;

public interface UserService {
    void save(User user);
    User findById(Long id);
    User findByName(String name);
}
