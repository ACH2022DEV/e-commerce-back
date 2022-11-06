package com.pfa.ecommerce.services.intf;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    public Page<Article> getAll(Pageable pageable);
    public Optional<Article> findById(Long id);
    public Article save(Article article);
    public Article update(Article article);
    public boolean delete(Long id);


   public Page<Article> getSearch(Pageable pageable,String keyword);
    public Page<Article> SearchByNbAvis(Pageable pageable,Integer NbAvis);
    public Page<Article> SearchByRmise(Pageable pageable,Integer remise);
}
