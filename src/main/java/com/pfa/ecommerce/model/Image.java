package com.pfa.ecommerce.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Image {

    private Long id;
    private String name;
    private String type;
    private byte[] picbyte;


    public Image(String fileName, String contentType, byte[] bytes) {
        this.name = fileName;
        this.type  = contentType;
        this.picbyte = bytes;

    }
}
