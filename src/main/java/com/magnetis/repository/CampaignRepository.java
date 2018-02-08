package com.magnetis.repository;

import com.magnetis.domain.Campaign;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    List<Campaign> findByName(String name);
    List<Campaign> findByNameIsLike(String name);
}
