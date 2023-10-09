package com.sistem.testing.exceptions;

//clase para indicar que este usuario NO se encuentra en la base de datos
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User does not exist in the database");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
