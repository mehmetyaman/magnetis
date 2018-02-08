package com.magnetis.repository;

import com.magnetis.domain.MagMessage;
import com.magnetis.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MagMessageRepository extends CrudRepository<MagMessage, Long> {

    List<MagMessage> findByFrom(User user);
    List<MagMessage> findByTo(User user);
}
