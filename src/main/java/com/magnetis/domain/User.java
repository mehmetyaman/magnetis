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
public class User {
    public User() {
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
    @Getter @Setter private List<UserOrder> orders;
    @Getter @Setter private Double points;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birth, user.birth) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(eMail, user.eMail) &&
                Objects.equals(password, user.password) &&
                Objects.equals(orders, user.orders) &&
                Objects.equals(points, user.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birth, phoneNumber, eMail, password, orders, points);
    }
}
