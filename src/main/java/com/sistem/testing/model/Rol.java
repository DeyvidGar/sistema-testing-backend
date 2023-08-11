package com.sistem.testing.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Rol {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    //representacion de relacion inversa
    //lazy: carga perezosa, es decir los tados solo se cargan si creamos la funcion
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private Set<UserRol> usersRols = new HashSet<>();

    public Rol() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRol> getUsersRols() {
        return usersRols;
    }

    public void setUsersRols(Set<UserRol> usersRols) {
        this.usersRols = usersRols;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Rol rol = (Rol) o;
//        return id == rol.id && Objects.equals(name, rol.name) && Objects.equals(usersRols, rol.usersRols);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, usersRols);
//    }
}
