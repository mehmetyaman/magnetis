package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Objects;

@Entity
@Transactional
public class CustomerOrder {

    public CustomerOrder() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @Getter
    @Setter
    private Product product;
    @Getter
    @Setter
    private Date orderDate;
    @Getter
    @Setter
    private Double orderAmount;

    @ManyToOne
    @Getter
    @Setter
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(orderAmount, that.orderAmount) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, orderDate, orderAmount, customer);
    }
}
