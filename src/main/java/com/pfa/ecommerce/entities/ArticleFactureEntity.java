package com.pfa.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="r_facture_article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleFactureEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "FactureId")
    private FactureEntity facture;

    @ManyToOne
    @JoinColumn(name = "codeArticle")
    private ArticleEntity article;

    private Long quatite;

    private Float remise;

}

