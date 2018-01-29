package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Entity
@Transactional
public class Customer {
    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private Date birth;
    @Getter @Setter private String phoneNumber;
    @OneToMany
    @Getter @Setter private List<CustomerOrder> orders;
    @Getter @Setter private Double points;
}
