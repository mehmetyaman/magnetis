package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(categories, company.categories) &&
                Objects.equals(compaigns, company.compaigns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categories, compaigns);
    }
}
