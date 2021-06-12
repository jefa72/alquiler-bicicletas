package com.jesoftware.alquilerbicicletas.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long user_Id;
    private String name;
    private String password;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Alquiler> alquileres = new ArrayList<>();

    public User(){

    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public boolean addAlquiler(Alquiler alquiler){
        return alquileres.add(alquiler);
    }
}
