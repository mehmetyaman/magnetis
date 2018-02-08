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
public class User {
    public User() {
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private Date birth;
    @Getter
    @Setter
    private String phoneNumber;
    @Column(unique = true)
    @Getter
    @Setter
    private String eMail;
    @Getter
    @Setter
    private String password;

    @OneToMany
    @Getter
    @Setter
    private List<UserOrder> orders;
    @Getter
    @Setter
    private Double points;

    @OneToMany
    @Getter
    @Setter
    private List<Company> memberedCompanies;

}
