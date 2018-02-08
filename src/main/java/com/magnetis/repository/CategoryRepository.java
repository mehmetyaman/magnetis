package com.magnetis.repository;

import com.magnetis.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
    List<Category> findByNameContains(String name);
}
