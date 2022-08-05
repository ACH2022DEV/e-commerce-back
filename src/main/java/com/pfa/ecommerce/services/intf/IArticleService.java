package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.model.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    public List<Article> getAll();
    public Optional<Article> findById(Long id);
    public Article save(Article article);
    public Article update(Article article);
    public boolean delete(Long codeArticle);
}
