package com.magnetis.repository;

import com.magnetis.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);
    List<Product> findByLongDesc(String longDesc);
    List<Product> findByShortDesc(String shortDesc);
    List<Product> findByNameContains(String name);
    List<Product> findByLongDescContains(String longDesc);
    List<Product> findByShortDescContains(String shortDesc);
}
