package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Image;
import com.pfa.ecommerce.model.Personne;
import com.pfa.ecommerce.repository.*;
import com.pfa.ecommerce.services.intf.IPersonneService;
import com.pfa.ecommerce.services.intf.IimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
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


	@GetMapping()
	public List<Personne> list(@RequestParam(defaultValue = "0") int pageNo) {
		return personneService.findAll(pageNo);
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

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		//Nouveau ligne

		/*panierRepository.findbyPersonneId(id).forEach(panierRepository::delete);
		devisRepository.findbyPersonneId(id).forEach(devisRepository::delete);*/

		 personneService.delete(id);
	}

	@PutMapping
	public Personne update(@RequestBody Personne personne) {
		return personneService.update(personne);
	}

}
