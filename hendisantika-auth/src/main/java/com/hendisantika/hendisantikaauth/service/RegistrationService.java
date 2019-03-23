package com.hendisantika.hendisantikaauth.service;

import com.hendisantika.hendisantikaauth.model.User;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-24
 * Time: 05:48
 */
public interface RegistrationService {
    void registerUser(User user);

    void confirmUser(String token, String password);

    boolean isUserRegistered(User user);

    User getUserForToken(String token);
}
