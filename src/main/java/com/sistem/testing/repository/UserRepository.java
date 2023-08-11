package com.sistem.testing.repository;

import com.sistem.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //por convencion spring reconoce que debe encontrar en la base de datos, en este repo el User con un determinado username
    public User findByUsername(String username);
}
