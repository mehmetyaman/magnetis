package com.magnetis.controller;

import com.magnetis.domain.Customer;
import com.magnetis.exception.ExceptionStatics;
import com.magnetis.exception.UserCreationException;
import com.magnetis.exception.UserNotFoundException;
import com.magnetis.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Customer> list() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/customer/login", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Customer getCustomer(@RequestParam("email") String email, @RequestParam("pass") String pass) {
        Customer c = customerService.getCustomerByEmailAndPassword(email, pass);
        if (c != null) return c;
        LOGGER.error("can not find any user with params:" + email + " and :" + pass);
        throw new UserNotFoundException(ExceptionStatics.CAN_NOT_FIND_USER);
    }

    @RequestMapping(value = "/customer/register", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Customer register(@RequestBody Customer customer) {
        try {
            customerService.save(customer);
        } catch (Exception e) {
            LOGGER.error("can registered user with given parameters:" + customer);
            throw new UserCreationException(ExceptionStatics.CAN_NOT_CREATE_USER);
        }
        return customer;
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
