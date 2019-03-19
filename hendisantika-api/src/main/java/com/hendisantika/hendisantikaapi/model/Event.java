package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-19
 * Time: 07:19
 */
@Entity
@Table(name = "events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "people_events", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "event_id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
    @JsonIgnoreProperties("events")
    private Set<Person> people = new HashSet<Person>();

    @OneToMany(mappedBy = "event")
    @JsonIgnoreProperties("event")
    private Set<Audition> auditions = new HashSet<Audition>();

}