package com.magnetis.repository;

import com.magnetis.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByEMailAndPassword(String email, String password);
    List<User> findByEMailContains(String searchText);
    List<User> findByFirstNameContains(String searchText);
    List<User> findByLastNameContains(String searchText);
    List<User> findByPhoneNumberContains(String searchText);

}
