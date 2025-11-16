package com.hendisantika.hendisantikaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hendisantika.hendisantikaapi.model.enums.Instrument;
import com.hendisantika.hendisantikaapi.model.enums.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-19
 * Time: 07:18
 */
@Entity
@Table(name = "skills")
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;

    @Column(name = "instrument")
    @Enumerated(EnumType.STRING)
    private Instrument instrument;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;

    protected Skill() {
        // hibernate
    }
}