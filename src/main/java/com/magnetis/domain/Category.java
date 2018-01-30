package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Entity
@Transactional
public class Category {
    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    @Column(unique = true)
    private String name;
    @OneToMany
    @Getter
    @Setter
    private List<Product> products;
    @Getter
    @Setter
    private Boolean visible;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(products, category.products) &&
                Objects.equals(visible, category.visible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products, visible);
    }
}
