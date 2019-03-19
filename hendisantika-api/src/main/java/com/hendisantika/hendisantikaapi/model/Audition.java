package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hendisantika.hendisantikaapi.model.enums.Instrument;
import com.hendisantika.hendisantikaapi.model.enums.Level;
import lombok.Data;

import javax.persistence.*;
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
@Table(name = "auditions")
@Data
public class Audition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "audition_id")
    private long id;

    @Column(name = "instrument")
    @Enumerated(EnumType.STRING)
    private Instrument instrument;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "people_auditions", joinColumns = @JoinColumn(name = "audition_id", referencedColumnName = "audition_id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
    private Set<Person> candidates = new HashSet<Person>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "owner_id")
    private Person owner;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "selected_musician_id")
    private Person selectedMusician;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "event_id")
    private Event event;

}