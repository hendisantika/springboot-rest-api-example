package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hendisantika.hendisantikaapi.model.enums.EnsembleType;
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
 * Time: 07:17
 */
@Entity
@Table(name = "ensembles")
@Data
public class Ensemble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ensemble_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ensemble_type")
    @Enumerated(EnumType.STRING)
    private EnsembleType ensembleType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "people_ensembles", joinColumns = @JoinColumn(name = "ensemble_id", referencedColumnName = "ensemble_id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
    @JsonIgnoreProperties("ensembles")
    private Set<Person> people = new HashSet<Person>();

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
