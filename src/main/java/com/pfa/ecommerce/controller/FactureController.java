package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.services.intf.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/facture")
public class FactureController {


	  @Autowired
	  IFactureService factureService;

	 @GetMapping
	 public List<Facture> list(){ return factureService.getAll(); }

	@GetMapping("/{id}")
	 public Optional<Facture> getFacture(@PathVariable Integer Id){
		 return factureService.findById(Id); }

	@PostMapping
	  public Facture save(@RequestBody Facture facture){ return factureService.save(facture); }

	@DeleteMapping("/{id}")
	  public void delete(@PathVariable Integer Id){ factureService.delete(Id); }

	@PutMapping("/{id}")
	  public Facture update(@PathVariable Integer Id,@RequestBody Facture facture){ return
	  factureService.update(Id, facture); }


}
