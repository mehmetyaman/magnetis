package com.magnetis.controller;

import com.magnetis.domain.User;
import com.magnetis.exception.ExceptionStatics;
import com.magnetis.exception.UserCreationException;
import com.magnetis.exception.UserNotFoundException;
import com.magnetis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public Iterable<User> list() {
        return userService.findAll();
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getCustomer(@RequestParam("email") String email, @RequestParam("pass") String pass) {
        User c = userService.getCustomerByEmailAndPassword(email, pass);
        if (c != null) return c;
        LOGGER.error("can not find any user with params:" + email + " and :" + pass);
        throw new UserNotFoundException(ExceptionStatics.CAN_NOT_FIND_USER);
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> searchCustomer(@RequestParam("searchText") String searchText, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        List<User> users = userService.searchCustomer(searchText);
        if (!CollectionUtils.isEmpty(users)) return users;
        LOGGER.error("can not find any user with params:" + searchText);
        throw new UserNotFoundException(ExceptionStatics.CAN_NOT_FIND_USER);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User register(@RequestBody User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            LOGGER.error("can registered user with given parameters:" + user);
            throw new UserCreationException(ExceptionStatics.CAN_NOT_CREATE_USER);
        }
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User read(@PathVariable(value = "id") long id) {
        return userService.getCustomer(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") long id) {
        userService.delete(id);
    }

}
