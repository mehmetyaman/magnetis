package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

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
    private String name;
    @OneToMany
    @Getter @Setter private List<Product> products;
    @Getter @Setter private Boolean visible;
}
