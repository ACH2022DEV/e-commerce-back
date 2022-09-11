package com.pfa.ecommerce.controller;



import com.pfa.ecommerce.entities.dto.CreateAvisDto;
import com.pfa.ecommerce.entities.dto.CreateDevis;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Avis;
import com.pfa.ecommerce.services.intf.IAvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    IAvisService avisService;
    @GetMapping
    public List<Avis> list() {
        return avisService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Avis> getAvis(@PathVariable Long id) {
        return avisService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avisService.delete(id);
    }
    @PostMapping
    public void save(@RequestBody CreateAvisDto avis) {
         avisService.save(avis);
    }

}
