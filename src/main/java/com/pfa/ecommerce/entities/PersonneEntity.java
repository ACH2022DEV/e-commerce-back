package com.pfa.ecommerce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.pfa.ecommerce.model.Facture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personne")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonneEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private String adress;
	@Column(nullable = false)
	private String tel;

	/*@OneToMany(mappedBy="personne",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JoinColumn(name="personne_id")
	 private List<Facture> factures ;
*/
}
