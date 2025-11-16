/* USERS */
DROP TABLE IF EXISTS users;
CREATE TABLE users (
                       user_id bigint PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    confirmation_token VARCHAR(256),
                       enabled bool
);
