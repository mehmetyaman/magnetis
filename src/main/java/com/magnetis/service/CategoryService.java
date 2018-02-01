package com.magnetis.service;


import com.magnetis.domain.Category;
import com.magnetis.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Category save(Category category){
        return repository.save(category);
    }

    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    public Category getCategory(Long id) {
        return repository.findOne(id);
    }

    public Category update(Category category) {
        return repository.save(category);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
