package com.pfa.ecommerce.entities;

import com.pfa.ecommerce.model.Article;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="avis")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvisEntity implements Serializable {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String message;

    @Column(nullable=false)
    private Integer etoile;

    @ManyToOne
    @JoinColumn(name = "Avis_PersonneId")
    private PersonneEntity personne;
    @ManyToOne
    @JoinColumn(name = "Avis_ArticleId")
    private ArticleEntity article;
    private LocalDateTime dateAvis;



}
