package com.magnetis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Objects;

@Entity
@Transactional
public class Campaign {
    public Campaign() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Double discountRatio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(id, campaign.id) &&
                Objects.equals(name, campaign.name) &&
                Objects.equals(discountRatio, campaign.discountRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, discountRatio);
    }
}
