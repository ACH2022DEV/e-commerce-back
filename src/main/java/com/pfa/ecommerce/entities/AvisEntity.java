package com.pfa.ecommerce.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="avis")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvisEntity {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String message;

    @Column(nullable=false)
    private Integer etoile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id", nullable = false)
    private PersonneEntity personne;


}
