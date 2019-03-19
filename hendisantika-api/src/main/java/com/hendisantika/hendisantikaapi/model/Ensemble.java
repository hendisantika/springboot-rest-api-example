package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hendisantika.hendisantikaapi.model.enums.EnsembleType;
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
 * Time: 07:17
 */
@Entity
@Table(name = "ensembles")
@Data
public class Ensemble {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
