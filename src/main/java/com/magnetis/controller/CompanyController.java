package com.magnetis.controller;

import com.magnetis.domain.Company;
import com.magnetis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/company", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Company> list() {
        return companyService.findAll();
    }
}
