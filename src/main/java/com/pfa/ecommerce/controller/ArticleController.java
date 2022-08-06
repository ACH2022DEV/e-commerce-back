package com.pfa.ecommerce.controller;

import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.services.intf.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/article")
public class ArticleController {

	  @Autowired
	   IArticleService articelService;

	@GetMapping
	  public List<Article> list() { return articelService.getAll(); }

	@GetMapping("/{id}")
	  public Optional<Article> getArticle(@PathVariable Long id) { return
	  articelService.findById(id); }

	@PostMapping
	  public Article save(@RequestBody Article article) {
		  return articelService.save(article); }

	@DeleteMapping("/{id}")
	  public void delete(@PathVariable Long id) { articelService.delete(id); }

	@PutMapping
	public Article update( @RequestBody Article article) {
		  return articelService.update( article); }


}
