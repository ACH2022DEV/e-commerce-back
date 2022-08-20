package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ERole;
import com.pfa.ecommerce.entities.RoleEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Personne {

    private Long id;

    private String nom;

    private String prenom;

    private String adress;

    private String tel;

    private String username;


    private String email;


    private String password;

    private RoleEntity role;

}
