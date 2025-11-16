package com.hendisantika.hendisantikaapi.model;

import com.hendisantika.hendisantikaapi.model.enums.Instrument;
import com.hendisantika.hendisantikaapi.model.enums.Level;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-22
 * Time: 06:10
 */
public class AuditionTest {
    @Test
    public void auditionIsCreatedCorrectly() {
        Person person = new Person();
        person.setFirstName("Naruto");

        Event event = new Event();
        event.setName("Party");

        Audition audition = new Audition();
        audition.setId(1L);
        audition.setEvent(event);
        audition.setOwner(person);
        audition.setCandidates(new HashSet<>());
        audition.setSelectedMusician(null);
        audition.setInstrument(Instrument.PIANO);
        audition.setLevel(Level.ADVANCED);

        assertEquals(1L, audition.getId());
        assertEquals(event, audition.getEvent());
        assertEquals(person, audition.getOwner());
        assertEquals(0, audition.getCandidates().size());
        assertNull(audition.getSelectedMusician());
        assertEquals(Instrument.PIANO, audition.getInstrument());
        assertEquals(Level.ADVANCED, audition.getLevel());
    }
}
