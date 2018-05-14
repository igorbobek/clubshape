package com.clubshape.clubshape.repository;

import com.clubshape.clubshape.entity.UserFormPlayer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserFormRepository extends CrudRepository<UserFormPlayer, Long> {
}
