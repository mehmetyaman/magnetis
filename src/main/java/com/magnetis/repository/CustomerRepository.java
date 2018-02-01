package com.magnetis.repository;

import com.magnetis.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByPhoneNumber(String phoneNumber);

    List<Customer> findByEMailAndPassword(String email, String password);
    List<Customer> findByEMailIsLike(String searchText);
    List<Customer> findByFirstNameIsLike(String searchText);
    List<Customer> findByLastNameIsLike(String searchText);
    List<Customer> findByPhoneNumberIsLike(String searchText);
}
