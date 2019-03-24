package com.hendisantika.hendisantikaauth.controller;

import com.hendisantika.hendisantikaauth.model.CustomPrincipal;
import com.hendisantika.hendisantikaauth.model.User;
import com.hendisantika.hendisantikaauth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-25
 * Time: 06:47
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/user")
    public CustomPrincipal user(Principal principal) {
        log.debug("Getting user based on principal: {}", principal.getName());

        // return principal with id as username
        User user = userRepo.findOneByEmail(principal.getName());

        CustomPrincipal cust = new CustomPrincipal();
        cust.setUsername(user.getId().toString());

        return cust;
    }

}