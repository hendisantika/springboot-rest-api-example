package com.hendisantika.hendisantikaapi.service;

import com.hendisantika.hendisantikaapi.model.Ensemble;
import com.hendisantika.hendisantikaapi.model.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-21
 * Time: 06:09
 */
@Service
public class ConnectionsServiceImpl implements ConnectionsService {

    @Override
    public Collection<Person> getConnections(Person person) {
        Set<Person> attendeeSuggestions = new HashSet<>();

        // add to suggestions all people in this person's ensembles
        for (Ensemble ensemble : person.getEnsembles()) {
            attendeeSuggestions.addAll(ensemble.getPeople());
        }

        // do not return the same person that requested connections
        attendeeSuggestions.remove(person);

        return attendeeSuggestions;
    }

}