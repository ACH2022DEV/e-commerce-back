package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Image;
import com.pfa.ecommerce.services.intf.IArticleService;
import com.pfa.ecommerce.services.intf.IimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.ImageFilter;
import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    IArticleService articelService;
    @Autowired
    IimagesService iimagesService;

    @GetMapping
    public List<Article> list() {
        return articelService.getAll();
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
        articelService.delete(id);
    }

    @PutMapping
    public Article update(@RequestBody Article article) {
        return articelService.update(article);
    }


}
