package com.magnetis.controller;

import com.magnetis.domain.Campaign;
import com.magnetis.service.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CampaignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
    CampaignService campaignService;

    @RequestMapping(value = "/campaign", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Campaign> list() {
        return campaignService.findAll();
    }


    @RequestMapping(value = "/campaign", method = RequestMethod.POST)
    public Campaign create(@RequestBody Campaign campaign
    ) {
        return campaignService.save(campaign);
    }

    @RequestMapping(value = "/campaign/{id}", method = RequestMethod.GET)
    public Campaign read(@PathVariable(value = "id") long id) {
        return campaignService.getCampaign(id);
    }

    @RequestMapping(value = "/campaign", method = RequestMethod.PUT)
    public Campaign update(@RequestBody Campaign campaign) {
        return campaignService.update(campaign);
    }

    @RequestMapping(value = "/campaign/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        campaignService.delete(id);
    }

}
