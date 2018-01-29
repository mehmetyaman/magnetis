package com.magnetis.repository;

import com.magnetis.domain.Customer;
import com.magnetis.domain.CustomerOrder;
import com.magnetis.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

    List<CustomerOrder> findByCustomer(Customer customer);
}
