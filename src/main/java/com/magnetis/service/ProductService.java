package com.magnetis.service;


import com.magnetis.domain.Product;
import com.magnetis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product getProduct(Long id) {
        return repository.findOne(id);
    }

    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    public Product update(Product product) {
        return repository.save(product);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
