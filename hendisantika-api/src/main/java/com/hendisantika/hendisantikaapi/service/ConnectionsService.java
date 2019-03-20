package com.hendisantika.hendisantikaapi.service;

import com.hendisantika.hendisantikaapi.model.Person;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-21
 * Time: 06:08
 */
public interface ConnectionsService {

    /**
     * This method returns list of connections of the specified person.
     * Currently, these connections are simply the people playing in this person's ensembles.
     *
     * @param person
     * @return list of connections of the person
     */
    Collection<Person> getConnections(Person person);

}