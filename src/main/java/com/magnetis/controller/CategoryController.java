package com.magnetis.controller;

import com.magnetis.domain.Category;
import com.magnetis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Category> list() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Category create(@RequestBody Category category
    ) {
        return categoryService.save(category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public Category read(@PathVariable(value = "id") long id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        categoryService.delete(id);
    }
}
