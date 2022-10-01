package com.pfa.ecommerce.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "images")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImagesEntity implements Serializable {


    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;
    private String type;
    @Column(length = 5000000)
    private byte[] picbyte;


}
