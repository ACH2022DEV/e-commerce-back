package com.pfa.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Panier")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PanierEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personneId")
    private PersonneEntity personne;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private ArticleEntity article;


    private int quantity;


    private LocalDateTime date;


}
