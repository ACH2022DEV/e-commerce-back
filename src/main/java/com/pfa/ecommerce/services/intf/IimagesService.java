package com.pfa.ecommerce.services.intf;


import com.pfa.ecommerce.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IimagesService {
    public Set<Image> uploadImage(MultipartFile[] files) throws IOException;


    public Optional<Image> getImage(long id);

    public List<Image> getALLimages();
    public boolean delete(Long id);
    //public Set<Image> uplod(MultipartFile[] multipartFiles) throws IOException;

}
