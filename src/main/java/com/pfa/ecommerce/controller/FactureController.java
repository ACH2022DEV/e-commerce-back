package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.services.intf.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/facture")
public class FactureController {


    @Autowired
    IFactureService factureService;

    @GetMapping
    public List<Facture> list() {
        return factureService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Facture> getFacture(@PathVariable Long id) {
        return factureService.findById(id);
    }

    @PostMapping
    public Facture save(@RequestBody Facture facture) {
        return factureService.save(facture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        factureService.delete(id);
    }

    @PutMapping
    public Facture update(@RequestBody Facture facture) {
        return factureService.update(facture);
    }


}
