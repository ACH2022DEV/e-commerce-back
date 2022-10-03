package com.pfa.ecommerce.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Image {
    @Schema(name="id", description = "l'identifiant technique de l'objet image ")
    private Long id;
    @Schema(name="name", description = "le nom d'image ")
    @NotBlank
    @Size(min = 0, max = 10)
    private String name;
    @Schema(name="type", description = "le type d'image ")
    @NotBlank
    @Size(min = 0, max = 50)
    private String type;
    @Schema(name="picbyte", description = "le nombre de bits de cette image ")

    private byte[] picbyte;


    public Image(String fileName, String contentType, byte[] bytes) {
        this.name = fileName;
        this.type  = contentType;
        this.picbyte = bytes;

    }
}
