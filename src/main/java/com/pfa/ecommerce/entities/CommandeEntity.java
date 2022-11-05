package com.pfa.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="Commande")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommandeEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String tel;
    @Column(nullable=false)
    private String adress;
    @ManyToOne
    @JoinColumn(name = "Commande_Personne")
    private PersonneEntity personne;
    private String CodePostal;
    private LocalDateTime dateCommande;
    private String dateLivraison;
    @ManyToOne
    @JoinColumn(name = "articleId")
    private ArticleEntity article;
    private Integer montantTotal;
    private Integer quantity;
    private String Lepayment;
    @Column(nullable=false)
    private String ville;
}
