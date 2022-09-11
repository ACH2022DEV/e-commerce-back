package com.pfa.ecommerce.controller;


import com.pfa.ecommerce.entities.dto.CreateUpdatePanierDto;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Panier;
import com.pfa.ecommerce.repository.PanierRepository;
import com.pfa.ecommerce.services.intf.IPanierService;
import com.pfa.ecommerce.services.intf.IPersonneService;
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
    @Autowired
    IPersonneService iPersonneService;
    @Autowired
    PanierRepository panierRepository;

    @GetMapping
    public List<Panier> list() {
        return iPanierService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Panier> getPanier(@PathVariable Long id) {
        return iPanierService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody CreateUpdatePanierDto panier) {

        iPanierService.save(panier);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        panierRepository.findbyPersonneId(id).forEach(panierRepository::delete);
        iPanierService.delete(id);
    }
}
