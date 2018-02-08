package com.magnetis.service;


import com.magnetis.domain.Content;
import com.magnetis.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contentService")
public class ContentService {

    @Autowired
    ContentRepository repository;

    public Content save(Content content) {
        return repository.save(content);
    }

    public Iterable<Content> findAll() {
        return repository.findAll();
    }

    public Content getContent(Long id) {
        return repository.findOne(id);
    }

    public Content update(Content content) {
        return repository.save(content);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<Content> search(String searchText) {
        List<Content> contents = repository.findByNameContains(searchText);
        return contents;
    }
}
