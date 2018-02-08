package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Objects;

@Entity
@Transactional
public class Product {
    public Product() {
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(unique = true)
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Date publishDate;
    @Getter
    @Setter
    private Boolean visible;
    @Getter
    @Setter
    private String imageUrl;
    @Getter
    @Setter
    private String imageThumbnailUrl;
    @Getter
    @Setter
    private Double cost;

    @Getter
    @Setter

    private String longDesc;

    @Getter
    @Setter
    private String shortDesc;
    @ManyToOne
    @Getter
    @Setter
    private Category category;

}
