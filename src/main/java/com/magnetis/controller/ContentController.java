package com.magnetis.controller;

import com.magnetis.domain.Content;
import com.magnetis.exception.ContentNotFoundException;
import com.magnetis.exception.ExceptionStatics;
import com.magnetis.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ContentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    ContentService service;

    @RequestMapping(value = "/content", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Content> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/content", method = RequestMethod.POST)
    public Content create(@RequestBody Content content
    ) {
        return service.save(content);
    }

    @RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
    public Content read(@PathVariable(value = "id") long id) {
        return service.getContent(id);
    }

    @RequestMapping(value = "/content", method = RequestMethod.PUT)
    public Content update(@RequestBody Content content, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        return service.update(content);
    }

    @RequestMapping(value = "/content/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        service.delete(id);
    }


    @RequestMapping(value = "/content/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Content> searchCustomer(@RequestParam("searchText") String searchText, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        List<Content> categories = service.search(searchText);
        if (!CollectionUtils.isEmpty(categories)) return categories;
        LOGGER.error("can not find any categories with params:" + searchText);
        throw new ContentNotFoundException(ExceptionStatics.CAN_NOT_FIND_CATEGORY);
    }
}
