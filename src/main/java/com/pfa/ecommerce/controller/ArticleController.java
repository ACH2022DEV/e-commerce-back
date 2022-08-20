package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Images;
import com.pfa.ecommerce.services.intf.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    IArticleService articelService;

    @GetMapping
    public List<Article> list() {
        return articelService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticle(@PathVariable Long id) {
        return
                articelService.findById(id);
    }

    @PostMapping()
    public Article save(@RequestParam("Article") Article article,
                        @RequestParam("imageFile") MultipartFile []  file   ) {
        try {
            Set<Images> images= uploadImage(file);
            article.setImages((List<Images>) images);
            return articelService.save(article);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    public   Set<Images> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Images> imageModel=new HashSet<>();
        for (MultipartFile file:  multipartFiles){
            Images images=new Images(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes(),
            );
            imageModel.add(images);
        }
        return imageModel;
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
