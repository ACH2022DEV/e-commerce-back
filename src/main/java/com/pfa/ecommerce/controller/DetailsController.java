package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Details;
import com.pfa.ecommerce.services.intf.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/details")
public class DetailsController {


    @Autowired
    IDetailsService iDetailsService;

    @GetMapping
    public List<Details> list(){ return iDetailsService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Details> getFacture(@PathVariable Integer Id){
        return iDetailsService.findById(Id); }

    @PostMapping
    public Details save(@RequestBody Details details){
        return iDetailsService.save(details); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer Id){ iDetailsService.delete(Id); }

    @PutMapping("/{id}")
    public Details update(@PathVariable Integer Id,@RequestBody Details details){
        return iDetailsService.update(Id, details); }


}

