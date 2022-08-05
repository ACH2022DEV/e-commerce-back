package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Devis;
import com.pfa.ecommerce.services.intf.IDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/devis")
public class DevisController {


	  @Autowired
	  IDevisService devisService;

	@GetMapping
	  public List<Devis> list(){ return devisService.getAll(); }

	@GetMapping("/{id}")
	  public Optional<Devis> getDevis(@PathVariable Integer Id){
		  return devisService.findById(Id); }

	  @PostMapping
	  public Devis save(@RequestBody Devis devis){ return devisService.save(devis); }

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer Id){ devisService.delete(Id); }

	@PutMapping("/{id}")
	 public Devis update(@PathVariable Integer Id,@RequestBody Devis devis){
		  return devisService.update(Id, devis); }

}
