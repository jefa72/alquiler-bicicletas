package com.jesoftware.alquilerbicicletas.resources;

import com.jesoftware.alquilerbicicletas.domain.Alquiler;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserResource {

    private Long user_Id;
    private String name;
    private String password;

    public UserResource(String name, String password){
        this.name = name;
        this.password = password;
    }

}
