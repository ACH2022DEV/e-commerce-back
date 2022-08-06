package com.pfa.ecommerce.entities;

import com.pfa.ecommerce.model.Personne;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Devis")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DevisEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codedevis;

    @Column(nullable = false)
    private Integer quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id", nullable = false)
    private PersonneEntity personne;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "r_devi_article", joinColumns = {
            @JoinColumn(name = "codedevis", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "codeArticle",
                    nullable = false, updatable = false)})
    private List<ArticleEntity> articles;


}
