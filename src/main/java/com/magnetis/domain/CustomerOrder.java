package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@Entity
@Transactional
public class CustomerOrder {

    public CustomerOrder() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @Getter @Setter private Product product;
    @Getter @Setter private Date orderDate;
    @Getter @Setter private Double orderAmount;

    @ManyToOne
    @Getter @Setter private Customer customer;
}
