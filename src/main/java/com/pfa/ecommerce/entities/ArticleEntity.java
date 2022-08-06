package com.pfa.ecommerce.entities;

import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="article")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleEntity implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeArticle;

	@Column(nullable=false)
	private String description;

	@Column(nullable=false)
	private String photo;

	@Column(nullable=false)
	private String paysOrigine;

	@Column(nullable=false)
	private Integer prix;

	@Column(nullable=false)
	private Integer tva;

	@Column(nullable=false)
	private Integer remise;

	@Column(nullable=false)
	private Integer quantite;


}
