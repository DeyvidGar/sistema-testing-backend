package com.sistem.testing;

import com.sistem.testing.model.Rol;
import com.sistem.testing.model.User;
import com.sistem.testing.model.UserRol;
import com.sistem.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SistemTestingBackendApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemTestingBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * test, creamos user
		 */
		/*
		User user = new User();
		user.setName("david");
		user.setLastName("garcia");
		user.setEmail("admin@admin.com");
		user.setPassword(passwordEncoder.encode("123"));
		user.setNumPhone("213123213");
		user.setUsername("admin");
		user.setPerfil("foto.jpg");


		Set<UserRol> usersRols = new HashSet<>();

		Rol rol = new Rol();
		rol.setId(1L);
		rol.setName("ADMIN");

		UserRol userRol = new UserRol();
		userRol.setRol(rol);
		userRol.setUser(user);

		usersRols.add(userRol);

		User userSaved = this.userService.saveUser(user, usersRols);
		System.out.println("guardado");
		*/

//		User user = this.userService.findByUserName("lolo3223");
//		System.out.println("user" + user);
//		System.out.println("user = " + user);

//		Set<UserRol> setlist = user.getUsersRols();
//		System.out.println("setlist = " + setlist);
	}
}
