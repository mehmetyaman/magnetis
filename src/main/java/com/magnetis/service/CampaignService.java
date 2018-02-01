package com.magnetis.service;

import com.magnetis.domain.Campaign;
import com.magnetis.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("campaignService")
public class CampaignService {
    
    @Autowired
    CampaignRepository repository;

    public Campaign save(Campaign campaign){
        return repository.save(campaign);
    }

    public Campaign getCampaign(Long id){
        return repository.findOne(id);
    }

    public Iterable<Campaign> findAll(){
        return repository.findAll();
    }

    public Campaign update(Campaign campaign) {
        return repository.save(campaign);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
