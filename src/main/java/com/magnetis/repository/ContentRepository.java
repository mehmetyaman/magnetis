package com.magnetis.repository;

import com.magnetis.domain.Content;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContentRepository extends CrudRepository<Content, Long> {

    List<Content> findByName(String name);
    List<Content> findByNameContains(String name);
}
