package com.magnetis.controller;

import com.magnetis.domain.Customer;
import com.magnetis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Customer> list() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/customer/login", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Customer getCustomer(@RequestParam("email") String email, @RequestParam("pass") String pass) {
        return customerService.getCustomerByEmailAndPassword(email, pass);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer create(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer read(@PathVariable(value = "id") long id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        customerService.delete(id);
    }
}
