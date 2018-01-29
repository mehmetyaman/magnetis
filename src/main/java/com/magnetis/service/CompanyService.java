package com.magnetis.service;

import com.magnetis.domain.Company;
import com.magnetis.domain.Customer;
import com.magnetis.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public Company save(Company comp){
        return repository.save(comp);
    }

    public Iterable<Company> findAll(){
        return repository.findAll();
    }

    public Company getCompany(Long id){
        return repository.findOne(id);
    }
}
