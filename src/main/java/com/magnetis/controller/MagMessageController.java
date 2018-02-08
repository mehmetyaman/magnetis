package com.magnetis.controller;

import com.magnetis.domain.MagMessage;
import com.magnetis.service.MagMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MagMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagMessageController.class);

    @Autowired
    MagMessageService service;

    @RequestMapping(value = "/magMessage", method = RequestMethod.GET, produces = "application/json")
    public Iterable<MagMessage> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/magMessage", method = RequestMethod.POST)
    public MagMessage create(@RequestBody MagMessage magMessage) {
        return service.save(magMessage);
    }

    @RequestMapping(value = "/magMessage/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        service.delete(id);
    }

}
