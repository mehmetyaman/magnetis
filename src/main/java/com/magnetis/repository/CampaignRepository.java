package com.magnetis.repository;

import com.magnetis.domain.Campaign;
import com.magnetis.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    List<Campaign> findByName(String name);
}
