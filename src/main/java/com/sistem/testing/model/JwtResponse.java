package com.sistem.testing.model;

//para cada respuesta en peticion
public class JwtResponse {
    private String token;

    public JwtResponse(){}

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
