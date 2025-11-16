/* USERS */
DROP TABLE IF EXISTS people;
CREATE TABLE people (
                        person_id  bigint PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    gender VARCHAR(8),
    location VARCHAR(32),
                        date_birth TIMESTAMP
);

/* ENSEMBLES */
DROP TABLE IF EXISTS ensembles;
CREATE TABLE ensembles (
                           ensemble_id bigint PRIMARY KEY AUTO_INCREMENT,
    ensemble_type VARCHAR(16),
                           name        VARCHAR(32)
);

/* PEOPLE-ENSEMBLES mapping */
DROP TABLE IF EXISTS people_ensembles;
CREATE TABLE people_ensembles (
  person_id BIGINT NOT NULL REFERENCES people (person_id),
  ensemble_id BIGINT NOT NULL REFERENCES ensembles (ensemble_id),
  PRIMARY KEY (person_id, ensemble_id)
);

/* SKILLS - user to skill mapping */
DROP TABLE IF EXISTS skills;
CREATE TABLE skills (
                        skill_id bigint PRIMARY KEY AUTO_INCREMENT,
    person_id BIGINT REFERENCES people (person_id),
    instrument VARCHAR(16),
    level VARCHAR(16)
);

/* VENUES */
DROP TABLE IF EXISTS venues;
CREATE TABLE venues (
                        venue_id  bigint PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(128),
    lat DOUBLE,
    lon DOUBLE,
                        google_id VARCHAR(128)
);

/* EVENTS */
DROP TABLE IF EXISTS events;
CREATE TABLE events (
                        event_id bigint PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64),
    owner_id BIGINT REFERENCES people (person_id),
    venue_id BIGINT REFERENCES venues (venue_id),
    start_date TIMESTAMP,
                        end_date TIMESTAMP
);

/* AUDITIONS */
DROP TABLE IF EXISTS auditions;
CREATE TABLE auditions (
                           audition_id bigint PRIMARY KEY AUTO_INCREMENT,
    instrument VARCHAR(16),
    level VARCHAR(16),
    owner_id BIGINT REFERENCES people (person_id),
    selected_musician_id BIGINT REFERENCES people (person_id),
                           event_id    bigint REFERENCES events (event_id)
);

/* PEOPLE-EVENTS mapping */
DROP TABLE IF EXISTS people_events;
CREATE TABLE people_events (
  person_id BIGINT NOT NULL REFERENCES people (person_id),
  event_id BIGINT NOT NULL REFERENCES events (event_id),
  PRIMARY KEY (person_id, event_id)
);

/* PEOPLE-AUDITIONS mapping */
DROP TABLE IF EXISTS people_auditions;
CREATE TABLE people_auditions (
  person_id BIGINT NOT NULL REFERENCES people (person_id),
  audition_id BIGINT NOT NULL REFERENCES auditions (audition_id),
  PRIMARY KEY (person_id, audition_id)
);
