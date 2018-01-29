package com.magnetis.controller;

import com.magnetis.domain.Category;
import com.magnetis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Category> list() {
        return categoryService.findAll();
    }

}
