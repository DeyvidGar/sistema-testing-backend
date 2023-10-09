package com.sistem.testing.exceptions;

//clase para indicar que este usuario YA se encuentra en la base de datos
public class UserFoundException extends Exception {

    public UserFoundException() {
        super("User already exist in the database");
    }

    public UserFoundException(String message) {
        super(message);
    }
}
