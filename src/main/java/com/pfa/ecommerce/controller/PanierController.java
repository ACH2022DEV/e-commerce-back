package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.entities.dto.CreateFacture;
import com.pfa.ecommerce.entities.dto.CreatePanier;
import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.model.Panier;
import com.pfa.ecommerce.services.intf.IFactureService;
import com.pfa.ecommerce.services.intf.IPanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/panier")
public class PanierController {
    @Autowired
    IPanierService iPanierService;

    @GetMapping
    public List<Panier> list() {
        return iPanierService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Panier> getFacture(@PathVariable Long id) {
        return iPanierService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody CreatePanier createPanier) {

         iPanierService.save(createPanier);
    }

    @PutMapping
    public Panier update(@RequestBody Panier panier) {
        return iPanierService.update(panier);
    }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
      iPanierService.delete(id);
  }
}
