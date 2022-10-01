package com.pfa.ecommerce.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Embeddable
public class ArticleEntity implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeArticle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String paysOrigine;

    @Column(nullable = false)
    private Integer prix;

    @Column(nullable = false)
    private Integer tva;

    @Column(nullable = false)
    private Integer remise;

    @Column(nullable = false)
    private Integer quantite;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "image_article", joinColumns = {
            @JoinColumn(name = "codeArticle", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "image_id",
                    nullable = false, updatable = false)})
    private List<ImagesEntity> images;

    //Pour l'etoile
    @OneToMany(mappedBy = "article")
    private List<AvisEntity> avis;


	/*@OneToMany(mappedBy = "article")
	private List<DevisArticleEntity> devis;
	@OneToMany(mappedBy = "article")
	private List<ArticleFactureEntity> facture;
	@OneToMany(mappedBy = "article")
	private List<PanierEntity> panier;*/


}
