package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.mappers.ArticleMapper;
import com.pfa.ecommerce.mappers.PersonneMapper;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.model.Personne;
import com.pfa.ecommerce.repository.ArticleRepository;
import com.pfa.ecommerce.services.intf.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl  implements IArticleService {


    @Autowired
    ArticleRepository repository;
    @Override
    public List<Article> getAll() {
        return ArticleMapper.INSTANCE.mapToModels(repository.findAll());
    }

    public Optional<Article> findById(Integer id) {
        return repository.findById(id).map(ArticleMapper.INSTANCE::mapToModel);
    }


 public Article save(Article article) {


        return ArticleMapper.INSTANCE.mapToModel(repository.save(ArticleMapper.INSTANCE.mapToEntity(article)));
    }
    public Article update(Integer codeArticle,Article article) {

            return ArticleMapper.INSTANCE.mapToModel(repository.save(ArticleMapper.INSTANCE.mapToEntity(article)));
        }



    public boolean delete(Integer codeArticle) {
        Optional<ArticleEntity> ar =repository.findById(codeArticle); if(ar.isPresent()) {
        repository.deleteById(codeArticle);
        }
    return true;
    }

}

