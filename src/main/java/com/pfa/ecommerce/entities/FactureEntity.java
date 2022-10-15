package com.pfa.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Column(name = "facture_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer montantTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id", nullable = false)
    private PersonneEntity personne;


    @OneToMany(mappedBy = "facture")
    private List<ArticleFactureEntity> articles;


}
