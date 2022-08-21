package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ImagesEntity;
import com.pfa.ecommerce.mappers.ArticleMapper;
import com.pfa.ecommerce.mappers.ImagesMapper;
import com.pfa.ecommerce.model.Images;
import com.pfa.ecommerce.repository.ImagesRepository;
import com.pfa.ecommerce.services.intf.IimagesService;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ImagesServiceImpl  implements IimagesService {
    @Autowired
    ImagesRepository imagesRepository;
    public Images UploadImage(MultipartFile file) throws IOException{
        String fileName=file.getOriginalFilename();
        Images images=new Images(fileName,file.getContentType(), file.getBytes());
        return ImagesMapper.INSTANCE.mapToModel(imagesRepository.save(ImagesMapper.INSTANCE.mapToEntity(images)));
    }
    public Optional<Images> getImage(long id){
        Optional<ImagesEntity> images= imagesRepository.findById(id);
        return imagesRepository.findById(id).map(ImagesMapper.INSTANCE::mapToModel);
    }
    public List<Images> getALLimages(){
        return ImagesMapper.INSTANCE.mapToModels(imagesRepository.findAll());
    }

}
