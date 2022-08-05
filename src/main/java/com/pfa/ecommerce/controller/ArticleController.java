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
	  public Optional<Article> getArticle(@PathVariable Integer Id) { return
	  articelService.findById(Id); }

	@PostMapping
	  public Article save(@RequestBody Article article) {
		  return articelService.save(article); }

	@DeleteMapping("/{id}")
	  public void delete(@PathVariable Integer Id) { articelService.delete(Id); }

	@PutMapping("/{id}")
	public Article update(@PathVariable Integer Id, @RequestBody Article article) {
		  return articelService.update(Id, article); }


}
