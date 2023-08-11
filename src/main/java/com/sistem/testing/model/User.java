package com.sistem.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//clase entity de jpa, mapearla con la bd
//ya que en el archivo de properties indicamos ddl-auto=update, hibernate se encarga de crear las tablas y ejecutar
//el sql enbase a la clase @entity
@Entity
public class User implements UserDetails {

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id autoincrement
    private long id;

    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String numPhone;
    private boolean enabled = true;
    private String perfil;

    //representacion de relacion inversa
    //eager: ancioso, es decir carga los datos relacionados
    //mappedBy: apunta al nombre del atributo de la clase de la relacion
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
//        , fetch = FetchType.LAZY)
    @JsonIgnore //para evitar errores en peticinoes
    private Set<UserRol> usersRols = new HashSet<>();

    public User() {
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //capturamos los roles de los usuario
        Set<Authority> auths = new HashSet<>();
        this.usersRols.forEach( userRol -> {
            auths.add(new Authority(userRol.getRol().getName()));
        });
        return auths;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Set<UserRol> getUsersRols() {
        return usersRols;
    }

    public void setUsersRols(Set<UserRol> usersRols) {
        this.usersRols = usersRols;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", numPhone='" + numPhone + '\'' +
                ", enabled=" + enabled +
                ", perfil='" + perfil + '\'' +
                '}';
    }

}
