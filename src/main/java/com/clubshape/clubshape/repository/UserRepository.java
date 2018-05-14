package com.clubshape.clubshape.repository;

import com.clubshape.clubshape.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);
    User findByName(String login);
    Optional<User> findById(Long id);
}
