package com.mistymorning.housekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistymorning.housekeeper.classes.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}