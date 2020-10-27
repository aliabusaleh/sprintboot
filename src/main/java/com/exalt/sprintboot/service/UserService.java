package com.exalt.sprintboot.service;

import com.exalt.sprintboot.dto.UserDto;
import com.exalt.sprintboot.model.User;
import com.exalt.sprintboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final   RoleService roleService ;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public User register(User user){
        //take the password from form encode!
        //assign a role to this User
        // set an activation code!
        //disable the user
        //save User

        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
       user.setEnabled(false);
       user.setPassword(secret);
       user .setConfirmPassword(secret);
       user.addRole(roleService.findByName("ROLE_USER"));
       //user.setActivationCode(UUID.randomUUID().toString());
       save(user);
      // sendActivationEmail(user);
       return user;
    }
    public User register_dto(UserDto userdto){
        User user = new User();
        String secret = "{bcrypt}" + encoder.encode(userdto.getPassword());
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setEmail(userdto.getEmail());
        user.setAlias(userdto.getAlias());
        user.setEnabled(false);
        user.setPassword(secret);
        user .setConfirmPassword(secret);
        user.addRole(roleService.findByName("ROLE_USER"));
        save(user);
        return user;
    }
    public User save(User user){
        return userRepository.save(user);
    }
    // do everything or don't do anything ! --> Transactional
    @Transactional
    public void saveUsers(User... users){
        for(User user: users){
            logger.info("Saving User: "+user.getEmail());
            userRepository.save(user);
        }
    }

    public void sendActivationEmail(User user){

    }
}
