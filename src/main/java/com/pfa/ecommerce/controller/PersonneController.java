package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.model.Image;
import com.pfa.ecommerce.model.Personne;
import com.pfa.ecommerce.repository.*;
import com.pfa.ecommerce.services.intf.IPersonneService;
import com.pfa.ecommerce.services.intf.IimagesService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personne")
public class PersonneController {
	@Autowired
	IPersonneService personneService;
	@Autowired
	PersonneRepository personneRepository;
	@Autowired
	PanierRepository panierRepository;
	@Autowired
	DevisArticleRepository devisArticleRepository;
	@Autowired
	DevisRepository devisRepository;
	@Autowired
	IimagesService iimagesService;
	@GetMapping("/search")
	public ResponseEntity<Page<Personne>> listBysearch(@ParameterObject Pageable pageable,@RequestParam String search) {
		Page<Personne> personnePage = personneService.getSearch(pageable,search);
		if (personnePage.hasContent()){
			return ResponseEntity.ok(personnePage);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@GetMapping
	public ResponseEntity<Page<Personne>> list(@ParameterObject Pageable pageable) {
		Page<Personne> personnePage = personneService.getAll(pageable);
		if (personnePage.hasContent()){
			return ResponseEntity.ok(personnePage);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@GetMapping("/{id}")
	public Optional<Personne> getPersonne(@PathVariable Long id) {
		return personneService.findById(id);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE})
	public Personne save(@RequestPart("personne") Personne personne,
						 @RequestPart("files") MultipartFile[] files)  throws IOException {
		Set<Image> imgs = iimagesService.uploadImage(files);
		personne.setImages(new ArrayList<>(imgs));
		return personneService.save(personne);
	}

	@PutMapping
	public Personne update(@RequestBody Personne personne) {
		return personneService.update(personne);
	}

}
