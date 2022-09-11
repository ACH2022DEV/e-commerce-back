package com.pfa.ecommerce.services.impl;

import com.pfa.ecommerce.entities.ImagesEntity;
import com.pfa.ecommerce.mappers.ImagesMapper;
import com.pfa.ecommerce.model.Image;
import com.pfa.ecommerce.repository.ImagesRepository;
import com.pfa.ecommerce.services.intf.IimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImagesServiceImpl implements IimagesService {
    @Autowired
    ImagesRepository imagesRepository;

    public Set<Image> uploadImage(MultipartFile[] file) throws IOException {
        Set<Image> images = uplod(file);
        return images.stream()
                .map(ImagesMapper.INSTANCE::mapToEntity)
                .map(imagesRepository::save)
                .map(ImagesMapper.INSTANCE::mapToModel)
                .collect(Collectors.toSet());


    }

    private Set<Image> uplod(MultipartFile[] multipartFiles) throws IOException {

        Set<Image> images = new HashSet<>();
        for (MultipartFile file : multipartFiles) {
            Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            images.add(image);
        }
        return images;

    }

    public Optional<Image> getImage(long id) {
        Optional<ImagesEntity> images = imagesRepository.findById(id);
        return imagesRepository.findById(id).map(ImagesMapper.INSTANCE::mapToModel);
    }

    public List<Image> getALLimages() {
        return ImagesMapper.INSTANCE.mapToModels(imagesRepository.findAll());
    }

}
