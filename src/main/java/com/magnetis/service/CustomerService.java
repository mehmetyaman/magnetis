package com.magnetis.service;

import com.magnetis.domain.Customer;
import com.magnetis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return repository.findOne(id);
    }

    public Customer getCustomerByEmailAndPassword(String email, String password) {
        List<Customer> customers = repository.findByEMailAndPassword(email, password);
        return customers != null && customers.size() > 0 ? customers.get(0) : null;
    }

    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
