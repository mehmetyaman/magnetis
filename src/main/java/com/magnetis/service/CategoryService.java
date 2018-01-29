package com.magnetis.service;


import com.magnetis.domain.Category;
import com.magnetis.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Iterable<Category> findAll(){
        return repository.findAll();
    }
}
