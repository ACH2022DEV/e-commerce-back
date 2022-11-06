package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ArticleEntity;
import com.pfa.ecommerce.mappers.ArticleMapper;
import com.pfa.ecommerce.mappers.PanierMapper;
import com.pfa.ecommerce.model.Article;
import com.pfa.ecommerce.repository.ArticleRepository;
import com.pfa.ecommerce.services.intf.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl  implements IArticleService {


    @Autowired
    ArticleRepository repository;


    @Override
    public Page<Article> getSearch(Pageable pageable,String keyword) {
        Page<ArticleEntity> articleEntityPage = repository.findBySearch(pageable,keyword);
        List<ArticleEntity> articleEntityList = articleEntityPage.stream().toList();
        List<Article> articleListList =
                ArticleMapper.INSTANCE.mapToModels(articleEntityList.stream().toList());


        return new PageImpl<>(articleListList, pageable, articleEntityPage.getTotalElements());
    }




    @Override
    public Page<Article> SearchByRmise(Pageable pageable,Integer remise) {
        Page<ArticleEntity> articleEntityPage = repository.findByremise(pageable,remise);
        List<ArticleEntity> articleEntityList = articleEntityPage.stream().toList();
        List<Article> articleListList =
                ArticleMapper.INSTANCE.mapToModels(articleEntityList.stream().toList());


        return new PageImpl<>(articleListList, pageable, articleEntityPage.getTotalElements());
    }

@Override
public Page<Article> SearchByNbAvis(Pageable pageable,Integer NbAvis) {
    Page<ArticleEntity> articleAvisPage = repository.findByAvis(pageable,NbAvis);
    List<ArticleEntity> articleEntityList = articleAvisPage.stream().toList();
    List<Article> articleListList =
            ArticleMapper.INSTANCE.mapToModels(articleEntityList.stream().toList());


    return new PageImpl<>(articleListList, pageable, articleAvisPage.getTotalElements());
}



    @Override
    public Page<Article> getAll(Pageable pageable) {

        Page<ArticleEntity> articleEntityPage = repository.findAll(pageable);
        List<ArticleEntity> articleEntityList = articleEntityPage.stream().toList();
        List<Article> articleListList =
                ArticleMapper.INSTANCE.mapToModels(articleEntityList.stream().toList());


        return new PageImpl<>(articleListList, pageable, articleEntityPage.getTotalElements());
    }

    public Optional<Article> findById(Long id) {
        return repository.findById(id).map(ArticleMapper.INSTANCE::mapToModel);
    }


 public Article save(Article article) {


        return ArticleMapper.INSTANCE.mapToModel(repository.save(ArticleMapper.INSTANCE.mapToEntity(article)));
    }
    public Article update(Article article) {

            return ArticleMapper.INSTANCE.mapToModel(repository.save(ArticleMapper.INSTANCE.mapToEntity(article)));
        }



    public boolean delete(Long id) {
        Optional<ArticleEntity> ar =repository.findById(id); if(ar.isPresent()) {
        repository.deleteById(id);
        }
    return true;
    }

}

