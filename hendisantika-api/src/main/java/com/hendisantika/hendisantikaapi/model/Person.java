package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hendisantika.hendisantikaapi.model.enums.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Set<Ensemble> getEnsembles() {
        return ensembles;
    }

    public void setEnsembles(Set<Ensemble> ensembles) {
        this.ensembles = ensembles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}