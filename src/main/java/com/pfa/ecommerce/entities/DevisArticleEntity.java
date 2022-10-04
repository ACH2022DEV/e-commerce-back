package com.pfa.ecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "r_devis_article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@Transactional
public class DevisArticleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "codedevis", nullable = false)
    private DevisEntity devis;

    @ManyToOne
    @JoinColumn(name = "codeArticle", nullable = false)
    private ArticleEntity article;
    private LocalDateTime dateEdition;


    private Long quatite;

    private Float remise;

}
