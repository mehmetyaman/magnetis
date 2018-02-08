package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@Entity
@Transactional
public class MagMessage {
    public MagMessage() {
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Getter
    @Setter
    private Date messageDate;

    @Getter
    @Setter
    @OneToOne
    private User from;

    @Getter
    @Setter
    @OneToOne
    private User to;

    @Getter
    @Setter
    private String content;

}
