package com.hendisantika.hendisantikaapi.controller;

import com.hendisantika.hendisantikaapi.model.Person;
import com.hendisantika.hendisantikaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-22
 * Time: 06:08
 */
@RestController
public class UserController {

    @Autowired
    private PersonRepository personRepo;

    /**
     * Returns currently logged user as Person object.
     *
     * @param user
     * @return currently logged user
     */
    @RequestMapping("/user")
    public Optional<Person> user(Principal user) {
        // username ireturned in principal is user id
        return personRepo.findById(Long.parseLong(user.getName()));
    }

}