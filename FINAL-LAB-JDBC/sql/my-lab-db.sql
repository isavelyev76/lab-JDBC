CREATE TYPE PRIORITY_ENUM AS ENUM ('high', 'medium', 'low');

CREATE TYPE PROBABILITY_ENUM AS ENUM ('high', 'medium', 'low');

CREATE TYPE MARK_ENUM AS ENUM (
    'implementation completed', 
    'tested, successful', 
    'tested, unsuccessful', 
    'tested, needs revision'
);

CREATE TYPE LEVEL_ENUM AS ENUM ('surface', 'medium', 'deep');

CREATE TYPE RESULT_ENUM AS ENUM ('passed', 'failed');

CREATE TABLE "users" (
    "id"                  BIGSERIAL   PRIMARY KEY, /*было SERIAL*/
    "login"               TEXT     NOT NULL UNIQUE,
    "password"            TEXT     NOT NULL
    "role"                SMALLINT NOT NULL CHECK ("role" IN (1, 2))

    /*
        1 - ADMIN
        2 - TESTER
    */
);

CREATE TABLE "customer" (
    "id"                           BIGSERIAL  PRIMARY KEY,  /*было bigint*/
    "name"                         TEXT     NOT NULL,
    "legal_address"                TEXT     NOT NULL,
    "bank_details"                 INTEGER  NOT NULL,
);

CREATE TABLE "customers_contact_person" (
    "id"                           BIGSERIAL   PRIMARY KEY, /*было bigint*/
    "name"                         TEXT     NOT NULL,
    "surname"                      TEXT     NOT NULL,
    "patronymic"                   TEXT     NOT NULL,
    "customer_id"                  BIGINT   NOT NULL,

    CONSTRAINT customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer (id)
    ON UPDATE RESTRICT
    ON DELETE CASCADE
);

CREATE TABLE "phone" (
    "number"                      TEXT     PRIMARY KEY, /*нежелательное определение ключа*/
    "contact_person_id"           BIGINT  NOT NULL,

    CONSTRAINT contact_person_id_fk FOREIGN KEY (contact_person_id) REFERENCES customers_contact_person (id)
    ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE "email" (
    "email"                       TEXT     PRIMARY KEY, /*нежелательное определение ключа*/
    "contact_person_id"           BIGINT  NOT NULL,

    CONSTRAINT contact_person_id_fk FOREIGN KEY (contact_person_id) REFERENCES customers_contact_person (id)
    ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE "project" (
    "id"                           BIGSERIAL   PRIMARY KEY,
    "name"                         TEXT     NOT NULL,
    "date_of_beginning"            DATE     NOT NULL,
    "date_of_ending"               DATE,
    "customer_id"                  BIGINT   NOT NULL,

    CONSTRAINT project_customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer (id)
    ON UPDATE RESTRICT
    ON DELETE CASCADE
);

CREATE TABLE "requirements" (
    "id"                           BIGSERIAL   PRIMARY KEY,
    "requirement_text"             TEXT     NOT NULL,
    "date_of_beginning"            DATE,
    "planned_time"                 TIME     NOT NULL,
    "priority_of_execution_time"   PRIORITY_ENUM NOT NULL,
    "criticality_level"            PRIORITY_ENUM NOT NULL,
    "completion_mark"              MARK_ENUM,
    "probability_of_change"        PROBABILITY_ENUM NOT NULL,
    "project_id"                   BIGINT   NOT NULL,
    
    CONSTRAINT project_id_fk FOREIGN KEY (project_id) REFERENCES project (id)
    ON UPDATE RESTRICT
    ON DELETE CASCADE
);

CREATE TABLE "scheduled_tests" (
    "id"                           BIGSERIAL  PRIMARY KEY,
    "description_of_execution"     TEXT       NOT NULL,
    "expected_result"              TEXT       NOT NULL,
    "planned_execution_time"       TIME       NOT NULL,
    "test_level"                   LEVEL_ENUM NOT NULL,
    "requirement_id"               BIGINT     NOT NULL,
    
    CONSTRAINT requirement_id_fk FOREIGN KEY (requirement_id) REFERENCES requirements (id)
    ON UPDATE RESTRICT
    ON DELETE CASCADE
);

CREATE TABLE "performed_tests" (
    "id"                           BIGSERIAL   PRIMARY KEY,
    "datetime_of_beginning"        TIMESTAMP   NOT NULL,
    "execution_time"               TIME        NOT NULL,
    "result"                       RESULT_ENUM NOT NULL,
    "scheduled_test_id"            BIGINT      NOT NULL,
    
    CONSTRAINT scheduled_test_id_fk FOREIGN KEY (scheduled_test_id) REFERENCES scheduled_tests (id)
    ON UPDATE RESTRICT
    ON DELETE CASCADE
);