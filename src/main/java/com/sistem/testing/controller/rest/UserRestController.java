package com.sistem.testing.controller.rest;

import com.sistem.testing.model.Rol;
import com.sistem.testing.model.User;
import com.sistem.testing.model.UserRol;
import com.sistem.testing.model.common.ResponseModel;
import com.sistem.testing.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*") //abrimos peticinoes
public class UserRestController {

    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> saveUser(@RequestBody User user) throws Exception {

        //encriptamos la contraseña que ingreso el usuario
        user.setPassword( this.passwordEncoder.encode(user.getPassword()) );

        Set<UserRol> usersRols = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(2L);
        rol.setName("DEFAULT");

        UserRol userRol = new UserRol();
        userRol.setUser(user);
        userRol.setRol(rol);

        usersRols.add(userRol);

        try {
            return ResponseEntity.ok().body( new ResponseModel( this.userService.saveUser(user, usersRols)) );
        } catch (Exception e ) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( new ResponseModel(null) );
        }


    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findUser(@PathVariable String username) throws Exception {
        try {
            return ResponseEntity.ok(this.userService.findByUserName(username));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/is-exisist/{username}")
//    public ResponseEntity isUserExisist(@PathVariable String username) throws Exception {
//        try {
//            return ResponseEntity.ok(new ResponseModel(this.userService.findByUserName(username)));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ResponseModel(null));
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(this.userService.deleteUser(id));
    }
}
