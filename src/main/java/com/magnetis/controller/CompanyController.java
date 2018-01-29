package com.magnetis.controller;

import com.magnetis.domain.Company;
import com.magnetis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/company", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Company> list() {
        return companyService.findAll();
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Company create(@RequestBody Company company) {
        return companyService.save(company);
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Company read(@PathVariable(value = "id") long id) {
        return companyService.getCompany(id);
    }

    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    public Company update(@RequestBody Company company) {
        return companyService.update(company);
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        companyService.delete(id);
    }
}
