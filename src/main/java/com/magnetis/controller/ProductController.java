package com.magnetis.controller;

import com.magnetis.domain.Product;
import com.magnetis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Product> list() {
        return productService.findAll();
    }


    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product read(@PathVariable(value = "id") long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        productService.delete(id);
    }
}
