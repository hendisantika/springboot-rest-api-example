package com.hendisantika.hendisantikaapi.repository;

import com.hendisantika.hendisantikaapi.model.Venue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-20
 * Time: 21:11
 */
@Repository
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

    Page<Venue> findAll(Pageable pageable);

}