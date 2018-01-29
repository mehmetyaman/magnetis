package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 *
 */
@Entity
@Transactional
public class Company {
    public Company() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Getter
    @Setter
    private String name;

    @ManyToMany
    @Getter
    @Setter
    private List<Category> categories;

    @ManyToMany
    @Getter
    @Setter
    private List<Campaign> compaigns;

    public Company(String name) {
        this.name = name;
    }
}
