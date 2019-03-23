package com.hendisantika.hendisantikaauth.repository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-24
 * Time: 05:46
 */

import com.hendisantika.hendisantikaauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Access to the user data. JpaRepository grants us convenient access methods
 * here.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by email.
     *
     * @param username the user's username
     * @return user which contains the user with the given username or null.
     */
    User findOneByEmail(String email);

    /**
     * Find a user by confirmation token.
     *
     * @param confirmationToken
     * @return user associated with this confirmation token
     */
    User findByConfirmationToken(String confirmationToken);

    /**
     * Find a user by ID.
     *
     * @param id the user's ID
     * @return User returns an {@link User} which contains the user or null.
     */
    Optional<User> findById(Long id);
}