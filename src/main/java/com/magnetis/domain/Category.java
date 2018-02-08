package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Category {

    public Category() {
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String name;
    @Getter
    @Setter
    private Boolean visible;

}
