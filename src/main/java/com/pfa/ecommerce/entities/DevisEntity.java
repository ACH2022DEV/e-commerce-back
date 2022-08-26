package com.pfa.ecommerce.entities;

import com.pfa.ecommerce.model.Personne;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id", nullable = false)
    private PersonneEntity personne;


    @OneToMany(mappedBy = "devis")
    private List<DevisArticleEntity> articles;



}
