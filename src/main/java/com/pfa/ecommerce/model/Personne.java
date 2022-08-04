package com.pfa.ecommerce.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
