package com.magnetis.repository;

import com.magnetis.domain.User;
import com.magnetis.domain.UserOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<UserOrder, Long> {

    List<UserOrder> findByUser(User user);
}
