package com.sistem.testing.controller.rest;

import com.sistem.testing.config.JwtUtils;
import com.sistem.testing.model.JwtRequest;
import com.sistem.testing.model.JwtResponse;
import com.sistem.testing.model.User;
import com.sistem.testing.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private JwtUtils jwtUtils;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    //generar token con post
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authentication(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Bad credentials");
        }
        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authentication(String username, String password) throws Exception{
        try {
            //permiso
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException disabledException) {
            throw new Exception("User unable: " + disabledException.getMessage());
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Bad credentials: " + badCredentialsException.getMessage());
        }
    }

    @GetMapping("/user-logged")
    public User userLoggedIn(Principal principal){
        return (User) this.userDetailService.loadUserByUsername(principal.getName());
    }
}
