package com.magnetis.service;

import com.magnetis.domain.User;
import com.magnetis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class UserService {

    @Autowired
    UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public User getCustomer(Long id) {
        return repository.findOne(id);
    }

    public User getCustomerByEmailAndPassword(String email, String password) {
        List<User> users = repository.findByEMailAndPassword(email, password);
        return users != null && users.size() > 0 ? users.get(0) : null;
    }

    public  List<User> searchCustomer(String searchText) {
        List<User> users = repository.findByEMailIsLike(searchText);
        users.addAll(repository.findByFirstNameIsLike(searchText));
        users.addAll(repository.findByLastNameIsLike(searchText));
        users.addAll(repository.findByPhoneNumberIsLike(searchText));

        return users;
    }

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public User update(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}