package com.magnetis.repository;

import com.magnetis.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByPhoneNumber(String phoneNumber);

}
