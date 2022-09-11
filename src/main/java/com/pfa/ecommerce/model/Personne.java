package com.pfa.ecommerce.model;

import com.pfa.ecommerce.entities.ERole;
import com.pfa.ecommerce.entities.ImagesEntity;
import com.pfa.ecommerce.entities.PanierEntity;
import com.pfa.ecommerce.entities.RoleEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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
    private List<Panier> paniers;
     //Nouveau Modification (images pour l'utilisateur)
     private List<Image> images;
}
