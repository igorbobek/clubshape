package com.clubshape.clubshape.repository;

import com.clubshape.clubshape.entity.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClubRepository extends CrudRepository<Club,Long> {
    Club findByName(String name);
}
