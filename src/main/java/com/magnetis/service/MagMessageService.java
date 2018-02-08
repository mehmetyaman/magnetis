package com.magnetis.service;

import com.magnetis.domain.MagMessage;
import com.magnetis.repository.MagMessageRepository;
import com.magnetis.repository.MagMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("magMessageService")
public class MagMessageService {
    
    @Autowired
    MagMessageRepository repository;

    public MagMessage save(MagMessage magMessage){
        return repository.save(magMessage);
    }

    public MagMessage getMagMessage(Long id){
        return repository.findOne(id);
    }

    public Iterable<MagMessage> findAll(){
        return repository.findAll();
    }

    public MagMessage update(MagMessage magMessage) {
        return repository.save(magMessage);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
