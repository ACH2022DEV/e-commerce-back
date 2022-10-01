package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.entities.dto.CreateFacture;
import com.pfa.ecommerce.model.Facture;
import com.pfa.ecommerce.repository.ArticleFactureRepository;
import com.pfa.ecommerce.services.intf.IFactureService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/facture")
public class FactureController {


    @Autowired
    IFactureService factureService;
    @Autowired
    ArticleFactureRepository articleFactureRepository;

    @GetMapping
    public ResponseEntity<Page<Facture>> list(@ParameterObject Pageable pageable) {
        Page<Facture> facturePage = factureService.getAll(pageable);
        if (facturePage.hasContent()){
            return ResponseEntity.ok(facturePage);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }


    @GetMapping("/{id}")
    public Optional<Facture> getFacture(@PathVariable Long id) {
        return factureService.findById(id);
    }

    @PostMapping
    public Facture save(@RequestBody CreateFacture facture) {

        return factureService.save(facture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleFactureRepository.findbyFactureId(id).forEach(articleFactureRepository::delete);
        factureService.delete(id);
    }

    @PutMapping
    public Facture update(@RequestBody Facture facture) {
        return factureService.update(facture);
    }


}
