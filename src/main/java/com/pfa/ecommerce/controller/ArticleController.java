package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.entities.ImagesEntity;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Image;
import com.pfa.ecommerce.repository.*;
import com.pfa.ecommerce.services.intf.IArticleService;
import com.pfa.ecommerce.services.intf.IimagesService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    IArticleService articelService;
    @Autowired
    IArticleService articelService2;
    @Autowired
    IimagesService iimagesService;
    @Autowired
    DevisArticleRepository devisArticleRepository;
    @Autowired
    PanierRepository panierRepository;
    @Autowired
    ImagesRepository imagesRepository;
    @Autowired
    ArticleFactureRepository articleFactureRepository;
    @Autowired
    ArticleRepository repository;
    @Autowired
    ArticleRepository articleRepository;
//Methode search

@GetMapping("/search")
    public ResponseEntity<Page<Article>> listBysearch(@ParameterObject Pageable pageable,@RequestParam  String search) {
        Page<Article> articePage = articelService.getSearch(pageable,search);
        if (articePage.hasContent()) {
            return ResponseEntity.ok(articePage);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/searchByAvis")
    public ResponseEntity<Page<Article>> findByNbAvis(@ParameterObject Pageable pageable,@RequestParam  Integer NbAvis) {
        Page<Article> articePage = articelService2.SearchByNbAvis(pageable,NbAvis);
        if (articePage.hasContent()) {
            return ResponseEntity.ok(articePage);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Article>> list(@ParameterObject Pageable pageable) {
        Page<Article> articePage = articelService.getAll(pageable);
        if (articePage.hasContent()) {
            return ResponseEntity.ok(articePage);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticle(@PathVariable Long id) {
        return articelService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE})
    public Article save(@RequestPart("article") Article article,
                        @RequestPart("files") MultipartFile[] files) throws IOException {

        Set<Image> imgs = iimagesService.uploadImage(files);
        article.setImages(new ArrayList<>(imgs));


        return articelService.save(article);

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        devisArticleRepository.findbyArticleId(id).forEach(devisArticleRepository::delete);
        panierRepository.findbyArticleId(id).forEach(panierRepository::delete);
        articleFactureRepository.findbyArticleId(id).forEach(articleFactureRepository::delete);
        imagesRepository.findbyArticleId1(id).forEach(imagesRepository::delete);
        articelService.delete(id);
    }

 /*@PutMapping
         public Article update(@RequestBody Article article) {
             return articelService.update(article);
         }*/
    @DeleteMapping("/image/{id}")
    public void deleteImage(@PathVariable Long id) {
        iimagesService.delete(id);

    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE})
    public Article update(@RequestPart("article") Article article,
                        @RequestPart("files") MultipartFile[] files) throws IOException {

        Set<Image> imgs = iimagesService.uploadImage(files);
        article.setImages(new ArrayList<>(imgs));


        return articelService.update(article);

    }

}