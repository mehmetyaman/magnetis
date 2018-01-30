package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Transactional
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Product() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(publishDate, product.publishDate) &&
                Objects.equals(visible, product.visible) &&
                Objects.equals(imageUrl, product.imageUrl) &&
                Objects.equals(imageThumbnailUrl, product.imageThumbnailUrl) &&
                Objects.equals(cost, product.cost) &&
                Objects.equals(longDesc, product.longDesc) &&
                Objects.equals(shortDesc, product.shortDesc) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, publishDate, visible, imageUrl, imageThumbnailUrl, cost, longDesc, shortDesc, category);
    }
}
