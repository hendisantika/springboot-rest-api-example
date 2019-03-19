package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hendisantika.hendisantikaapi.model.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-19
 * Time: 07:16
 */
@Entity
@Table(name = "people")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "location")
    private String location;

    @Column(name = "date_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "people_ensembles", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"), inverseJoinColumns = @JoinColumn(name = "ensemble_id", referencedColumnName = "ensemble_id"))
    @JsonIgnoreProperties("people")
    private Set<Ensemble> ensembles = new HashSet<Ensemble>();

    @OneToMany(mappedBy = "person")
    private Set<Skill> skills = new HashSet<Skill>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "people_events", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"), inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "event_id"))
    @JsonIgnoreProperties("people")
    private Set<Event> events = new HashSet<Event>();

}