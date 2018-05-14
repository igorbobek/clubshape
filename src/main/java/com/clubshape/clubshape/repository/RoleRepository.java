package com.clubshape.clubshape.repository;

import com.clubshape.clubshape.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
