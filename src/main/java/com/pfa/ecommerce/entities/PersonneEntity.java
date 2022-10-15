package com.pfa.ecommerce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.pfa.ecommerce.model.Avis;
import com.pfa.ecommerce.model.Facture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personne")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonneEntity implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column()
    private String adress;

    @Column()
    private String tel;


    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;


    @ManyToOne
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private RoleEntity role;

    @OneToMany(mappedBy = "personne")
    private List<PanierEntity> paniers;
    //Nouveau Modification (images pour l'utilisateur)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "image_Personne", joinColumns = {
            @JoinColumn(name = "idPersonne", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "image_id",
                    nullable = false, updatable = false)})
    private List<ImagesEntity> images;

    private Boolean actif;
    @OneToMany(mappedBy = "personne")
    private List<AvisEntity> avis;


}
