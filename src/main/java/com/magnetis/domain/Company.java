package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Company {
    public Company() {
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

    private String city;

    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    private String postCode;

    @Getter
    @Setter
    private String companyCode;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String phone1;

    @Getter
    @Setter
    private String phone2;

    @Getter
    @Setter
    @Range(min = 0, max = 100)
    private int pointRatio;

    @OneToOne
    @Getter
    @Setter
    private User owner;

    @Getter
    @Setter
    /**
     * barber, coffee, grocery etc...
     */
    private String field;


    public Company(String name) {
        this.name = name;
    }


}
