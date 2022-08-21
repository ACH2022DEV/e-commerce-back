package com.pfa.ecommerce.services.intf;


import com.pfa.ecommerce.model.Images;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IimagesService {
    public Images UploadImage(MultipartFile [] file)throws IOException;
    public Set<Images> Uplod(MultipartFile [] multipartFiles) throws IOException;
    public Optional<Images> getImage(long id);

    public List<Images> getALLimages();

}
