package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hendisantika.hendisantikaapi.model.enums.Instrument;
import com.hendisantika.hendisantikaapi.model.enums.Level;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<Person> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Person> candidates) {
        this.candidates = candidates;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getSelectedMusician() {
        return selectedMusician;
    }

    public void setSelectedMusician(Person selectedMusician) {
        this.selectedMusician = selectedMusician;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}