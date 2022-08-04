package com.pfa.ecommerce.entities;

import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Devis")
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codedevis;




	@Column(nullable=false)
	private Integer codeArticle;
	@Column(nullable=false)
	private Integer quantite;
	
	
	
	/*@ManyToMany()
	@JoinTable(name="Devise_articles",joinColumns=@JoinColumn(name="codedevise"),
	inverseJoinColumns=@JoinColumn(name="codeArticle"))
	private List<ArticleEntity> articles;
*/




}
