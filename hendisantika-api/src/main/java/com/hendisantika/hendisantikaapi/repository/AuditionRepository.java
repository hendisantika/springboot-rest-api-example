package com.hendisantika.hendisantikaapi.repository;

import com.hendisantika.hendisantikaapi.model.Audition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-20
 * Time: 21:09
 */
@Repository
public interface AuditionRepository extends JpaRepository<Audition, Long> {

    Page<Audition> findAll(Pageable pageable);

}