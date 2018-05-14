package com.clubshape.clubshape.repository;

import com.clubshape.clubshape.entity.Form;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FormRepository extends CrudRepository<Form, Long> {
}
