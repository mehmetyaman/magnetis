package com.magnetis.repository;

import com.magnetis.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByEMailAndPassword(String email, String password);
    List<User> findByEMailIsLike(String searchText);
    List<User> findByFirstNameIsLike(String searchText);
    List<User> findByLastNameIsLike(String searchText);
    List<User> findByPhoneNumberIsLike(String searchText);
}
