package com.pfa.ecommerce.controller;



import com.pfa.ecommerce.entities.dto.CreateAvisDto;
import com.pfa.ecommerce.entities.dto.CreateDevis;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Avis;
import com.pfa.ecommerce.services.intf.IAvisService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    IAvisService avisService;
    @GetMapping("/search")
    public ResponseEntity<Page<Avis>> listBysearch(@ParameterObject Pageable pageable, @RequestParam  Integer Nbetoile) {
        Page<Avis> avisPage = avisService.getSearch(pageable,Nbetoile);
        if (avisPage.hasContent()) {
            return ResponseEntity.ok(avisPage);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @GetMapping
    public List<Avis> list() {
        return avisService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Avis> getAvis(@PathVariable Long id) {
        return avisService.findById(id);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        avisService.delete(id);
    }
    @PostMapping
    public void save(@RequestBody CreateAvisDto avis) {
         avisService.save(avis);
    }

}
