package com.pfa.ecommerce.model;

import lombok.*;

import javax.persistence.Column;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Images {
    private long id;
    private String name;
    private String type;

    private byte[] picbyte;
}
