package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Personne;
import com.pfa.ecommerce.services.intf.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personne")
public class PersonneController {
	@Autowired
	IPersonneService personneService;


	@GetMapping
	public List<Personne> list() {
		return personneService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Personne> getPersonne(@PathVariable Long id) {
		return personneService.findById(id);
	}

	@PostMapping
	public Personne save(@RequestBody Personne personne) {
		return personneService.save(personne);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personneService.delete(id);
	}

	@PutMapping()
	public Personne update(@RequestBody Personne personne) {
		return personneService.update(personne);
	}

}
