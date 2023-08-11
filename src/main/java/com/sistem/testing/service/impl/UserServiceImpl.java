package com.sistem.testing.service.impl;

import com.sistem.testing.model.User;
import com.sistem.testing.model.UserRol;
import com.sistem.testing.repository.RolRepository;
import com.sistem.testing.repository.UserRepository;
import com.sistem.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    //inject
    private UserRepository userRepository;
    private RolRepository rolRepository;
    public UserServiceImpl( UserRepository userRepository, RolRepository rolRepository ){
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }


    @Override
    public User saveUser(User user, Set<UserRol> usersRols) throws Exception {
        //buscamos por username antes de guardar
        User userExisist = this.userRepository.findByUsername(user.getUsername());
        if(userExisist != null){
            throw new Exception("This username is already exisist.");
        }

        //guardamos nuevo user
        //guardamos los roles, de la lista de UserRol
        for(UserRol userRol: usersRols){
            this.rolRepository.save(userRol.getRol());
        }

        //agregamos a nuestro obj la lista de valores
        user.getUsersRols().addAll(usersRols);

        System.out.println("User service: " + user.getUsersRols());

        userExisist = this.userRepository.save(user);
        System.out.println("userExisist: " + userExisist);
        return userExisist;
    }

    @Override
    public User findByUserName(String username) throws Exception {
        User userExisist = this.userRepository.findByUsername(username);

        if(userExisist == null){
            throw new Exception("Username not exisist.");
        }


        return userExisist;
    }

    @Override
    public boolean deleteUser(Long id) throws Exception {
        User userExisist = this.userRepository.findById(id).get();

        if(userExisist == null) {
            throw new Exception("User not fount.");
        }

        try {
            this.userRepository.delete(userExisist);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
