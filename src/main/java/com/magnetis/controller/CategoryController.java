package com.magnetis.controller;

import com.magnetis.domain.Category;
import com.magnetis.exception.CategoryNotFoundException;
import com.magnetis.exception.ExceptionStatics;
import com.magnetis.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService service;

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Category> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Category create(@RequestBody Category category
    ) {
        return service.save(category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public Category read(@PathVariable(value = "id") long id) {
        return service.getCategory(id);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public Category update(@RequestBody Category category, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        return service.update(category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        service.delete(id);
    }


    @RequestMapping(value = "/category/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> searchCustomer(@RequestParam("searchText") String searchText, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        List<Category> categories = service.search(searchText);
        if (!CollectionUtils.isEmpty(categories)) return categories;
        LOGGER.error("can not find any categories with params:" + searchText);
        throw new CategoryNotFoundException(ExceptionStatics.CAN_NOT_FIND_CATEGORY);
    }
}
