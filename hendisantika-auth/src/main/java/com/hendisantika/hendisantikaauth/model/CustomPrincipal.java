package com.hendisantika.hendisantikaauth.model;

import lombok.Data;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-24
 * Time: 05:45
 */
@Data
public class CustomPrincipal implements Principal {

    private String username;

    @Override
    public String getName() {
        return username;
    }

}