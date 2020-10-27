package com.exalt.sprintboot.repository;

import com.exalt.sprintboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Long> {


        Role findByName(String name);

}
