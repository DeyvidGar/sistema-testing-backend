package com.sistem.testing.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //ya que esta tabla es de pivote muchos a muchos, relaiconamos con las tablas de muchos a uno

//    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    @ManyToOne
    private Rol rol;

    //representacion de relacion
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private  User user;

    //nota: las relaciones many to one no necesitan de fetch.all
    public UserRol() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRol{" +
                "id=" + id +
                ", rol=" + rol +
                ", user=" + user +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserRol userRol = (UserRol) o;
//        return id == userRol.id && Objects.equals(rol, userRol.rol) && Objects.equals(user, userRol.user);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, rol, user);
//    }
}
