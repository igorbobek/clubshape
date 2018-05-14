package com.clubshape.clubshape.repository;

import com.clubshape.clubshape.entity.ClubForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClubFormRepository extends CrudRepository<ClubForm, Long> {
}
