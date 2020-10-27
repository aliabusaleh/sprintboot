package com.exalt.sprintboot.service;


import com.exalt.sprintboot.model.Role;
import com.exalt.sprintboot.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {


    private  final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public  Role findByName(String name){
        return roleRepository.findByName(name);
    }

}
