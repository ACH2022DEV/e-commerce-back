package com.pfa.ecommerce.entities;

import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.model.Personne;
import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="facture")
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	@Column(nullable=false)
	private Integer montantTotal;
	@Column(nullable=false)
	private Integer id_detail;
	
	
	/*@ManyToOne
	private Personne personne;*/
	
	
	/*@ManyToOne
	private Devis devis;
	
	
	@ManyToMany()
	@JoinTable(name="factures_articles",joinColumns=@JoinColumn(name="code"),
	inverseJoinColumns=@JoinColumn(name="codeArticle"))
	private List<ArticleEntity> articles;
*/


}
