package com.magnetis.controller;

import com.magnetis.domain.Product;
import com.magnetis.exception.ExceptionStatics;
import com.magnetis.exception.ProductNotFoundException;
import com.magnetis.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Product> list() {
        return service.findAll();
    }


    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product read(@PathVariable(value = "id") long id) {
        return service.getProduct(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/product/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> searchCustomer(@RequestParam("searchText") String searchText, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        List<Product> categories = service.search(searchText);
        if (!CollectionUtils.isEmpty(categories)) return categories;
        LOGGER.error("can not find any categories with params:" + searchText);
        throw new ProductNotFoundException(ExceptionStatics.CAN_NOT_FIND_PRODUCT);
    }
}
