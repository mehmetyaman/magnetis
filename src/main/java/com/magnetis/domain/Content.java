package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Content {
    public Content() {
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Getter
    @Setter
    @Column(unique = true)
    private String name;
    @Getter
    @Setter
    private Boolean visible;

    @Getter
    @Setter
    private String initialContent;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

}
