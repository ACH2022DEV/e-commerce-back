package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.entities.dto.CreateDevis;
import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.services.intf.IDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/devis")
public class DevisController {


	  @Autowired
	  IDevisService devisService;

	@GetMapping
	  public List<Devis> list(){ return devisService.getAll(); }

	@GetMapping("/{id}")
	  public Optional<Devis> getDevis(@PathVariable Long id){
		  return devisService.findById(id); }

	  @PostMapping
	  public Devis save(@RequestBody CreateDevis devis){
		// je dois mapper entre createDevis et devis

		return devisService.save(devis);
	}



	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){ devisService.delete(id); }

	@PutMapping
	 public Devis update(@RequestBody Devis devis){
		  return devisService.update(devis); }

}
