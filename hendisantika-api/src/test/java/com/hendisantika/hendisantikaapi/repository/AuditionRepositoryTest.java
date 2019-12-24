package com.hendisantika.hendisantikaapi.repository;

import com.hendisantika.hendisantikaapi.model.Audition;
import com.hendisantika.hendisantikaapi.model.enums.Instrument;
import com.hendisantika.hendisantikaapi.model.enums.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-22
 * Time: 06:11
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AuditionRepositoryTest {

    @Autowired
    private AuditionRepository auditionRepository;

    @Test
    public void retrievesAllAuditions() {
        Page<Audition> auditions = auditionRepository.findAll(PageRequest.of(0, 10));

        assertEquals(2, auditions.getTotalElements());
    }

    @Test
    public void retrievesAuditionById() {
        Optional<Audition> result = auditionRepository.findById(1l);

        assertEquals(Instrument.GUITAR, result.get().getInstrument());
        assertEquals(Level.ADVANCED, result.get().getLevel());
        assertEquals(1l, result.get().getEvent().getId());
        assertEquals(1l, result.get().getOwner().getId());
    }

}