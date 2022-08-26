package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ImagesEntity;
import com.pfa.ecommerce.mappers.ArticleMapper;
import com.pfa.ecommerce.mappers.ImagesMapper;
import com.pfa.ecommerce.model.Images;
import com.pfa.ecommerce.repository.ImagesRepository;
import com.pfa.ecommerce.services.intf.IimagesService;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
@Service
@Transactional
public class ImagesServiceImpl  implements IimagesService {
    @Autowired
    ImagesRepository imagesRepository;
    public Images UploadImage(MultipartFile [] file) throws IOException {

            Set<Images> images=Uplod(file);
            return ImagesMapper.INSTANCE.mapToModel(imagesRepository.save(ImagesMapper.INSTANCE.mapToEntity((Images) images)));

    }

    public Set<Images> Uplod(MultipartFile [] multipartFiles) throws IOException {

            Set<Images> images=new HashSet<>();
        for (MultipartFile file: multipartFiles){
            Images image = new Images(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            images.add(image);
        }
        return images;

    }
    public Optional<Images> getImage(long id){
        Optional<ImagesEntity> images= imagesRepository.findById(id);
        return imagesRepository.findById(id).map(ImagesMapper.INSTANCE::mapToModel);
    }
    public List<Images> getALLimages(){
        return ImagesMapper.INSTANCE.mapToModels(imagesRepository.findAll());
    }

}
