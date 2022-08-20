package com.pfa.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "images")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImagesEntity  implements Serializable {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    @Column(length = 5000000)
    private byte[] picbyte;


}
