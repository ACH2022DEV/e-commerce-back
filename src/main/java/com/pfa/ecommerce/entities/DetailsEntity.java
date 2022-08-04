package com.pfa.ecommerce.entities;

import com.pfa.ecommerce.model.Facture;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="details")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailsEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long code;
    @Column(nullable=false)
    private Integer quantite;
    @Column(nullable=false)
    private Integer codeArticle;


   /* @OneToMany(mappedBy="details",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="details_id")
    private List<Facture> factures ;
*/




}
