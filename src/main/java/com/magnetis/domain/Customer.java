package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @Column(unique=true) @Getter @Setter private String eMail;
    @Getter @Setter private String password;

    @OneToMany
    @Getter @Setter private List<CustomerOrder> orders;
    @Getter @Setter private Double points;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(birth, customer.birth) &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(eMail, customer.eMail) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(orders, customer.orders) &&
                Objects.equals(points, customer.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birth, phoneNumber, eMail, password, orders, points);
    }
}
