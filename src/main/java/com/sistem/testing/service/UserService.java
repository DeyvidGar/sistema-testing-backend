package com.sistem.testing.service;

import com.sistem.testing.model.User;
import com.sistem.testing.model.UserRol;

import java.util.Set;

public interface UserService {
    //ya que la realcin de m-m, agregamos la tabla intermedia, es decir la tabla pivote
    User saveUser(User user, Set<UserRol> usersRols) throws Exception;

    User findByUserName(String username) throws Exception;

    boolean deleteUser(Long id) throws Exception;
}
