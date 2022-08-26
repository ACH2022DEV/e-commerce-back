package com.pfa.ecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="r_devis_article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DevisArticleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "codedevis")
    private DevisEntity devis;

    @ManyToOne
    @JoinColumn(name = "codeArticle")
    private ArticleEntity article;

    private Long quatite;

    private Float remise;

}
