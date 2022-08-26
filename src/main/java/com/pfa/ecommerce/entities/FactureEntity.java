package com.pfa.ecommerce.entities;

import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.model.Personne;
import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "facture")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(nullable = false)
    private Integer montantTotal;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id", nullable = false)
	private PersonneEntity personne;


    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "r_facture_article", joinColumns = {
            @JoinColumn(name = "codefacture", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "codeArticle",
                    nullable = false, updatable = false)})
    private List<ArticleEntity> articles;*/


    @OneToMany(mappedBy = "facture")
    private List<ArticleFactureEntity> article;

}
