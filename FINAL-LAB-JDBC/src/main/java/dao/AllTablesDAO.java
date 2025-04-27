package dao;

import util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

final public class AllTablesDAO {
    private static final Connection connection = ConnectionManager.open();
    private static Statement statement = null;
    private static final String CREATE_PRIORITY_ENUM = "CREATE TYPE PRIORITY_ENUM AS ENUM ('high', 'medium', 'low');\n";
    private static final String CREATE_PROBABILITY_ENUM = "CREATE TYPE PROBABILITY_ENUM AS ENUM ('high', 'medium', 'low');\n";
    private static final String CREATE_MARK_ENUM = "CREATE TYPE MARK_ENUM AS ENUM (\n" +
            "    'implementation completed', \n" +
            "    'tested, successful', \n" +
            "    'tested, unsuccessful', \n" +
            "    'tested, needs revision'\n" +
            ");";
    private static final String CREATE_LEVEL_ENUM = "CREATE TYPE LEVEL_ENUM AS ENUM ('surface', 'medium', 'deep');\n";
    private static final String CREATE_RESULT_ENUM = "CREATE TYPE RESULT_ENUM AS ENUM ('passed', 'failed');";
    private static final String CREATE_USERS = "CREATE TABLE \"users\" (" +
            "    \"id\"                  BIGSERIAL   PRIMARY KEY," +
            "    \"login\"               TEXT     NOT NULL UNIQUE," +
            "    \"password\"            TEXT     NOT NULL," +
            "    \"role\"                SMALLINT NOT NULL CHECK (\"role\" IN (1, 2)));";       //  1 - ADMIN     2 - TESTER
    private static final String CREATE_CUSTOMER = "CREATE TABLE \"customer\" (\n" +
            "    \"id\"                           BIGSERIAL  PRIMARY KEY,  /*было bigint*/\n" +
            "    \"name\"                         TEXT     NOT NULL,\n" +
            "    \"legal_address\"                TEXT     NOT NULL,\n" +
            "    \"bank_details\"                 INTEGER  NOT NULL,\n" +
            ");";
    private static final String CREATE_CUSTOMER_CONTACT_PERSON = "CREATE TABLE \"customers_contact_person\" (\n" +
            "    \"id\"                           BIGSERIAL   PRIMARY KEY, /*было bigint*/\n" +
            "    \"name\"                         TEXT     NOT NULL,\n" +
            "    \"surname\"                      TEXT     NOT NULL,\n" +
            "    \"patronymic\"                   TEXT     NOT NULL,\n" +
            "    \"customer_id\"                  BIGINT   NOT NULL,\n" +
            "\n" +
            "    CONSTRAINT customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer (id)\n" +
            "    ON UPDATE RESTRICT\n" +
            "    ON DELETE CASCADE\n" +
            ");";
    private static final String CREATE_PHONE = "CREATE TABLE \"phone\" (\n" +
            "    \"number\"                      TEXT     PRIMARY KEY, /*нежелательное определение ключа*/\n" +
            "    \"contact_person_id\"           BIGINT  NOT NULL,\n" +
            "\n" +
            "    CONSTRAINT contact_person_id_fk FOREIGN KEY (contact_person_id) REFERENCES customers_contact_person (id)\n" +
            "    ON UPDATE RESTRICT ON DELETE CASCADE\n" +
            ");\n";
    private static final String CREATE_EMAIL = "CREATE TABLE \"email\" (\n" +
            "    \"email\"                       TEXT     PRIMARY KEY, /*нежелательное определение ключа*/\n" +
            "    \"contact_person_id\"           BIGINT  NOT NULL,\n" +
            "\n" +
            "    CONSTRAINT contact_person_id_fk FOREIGN KEY (contact_person_id) REFERENCES customers_contact_person (id)\n" +
            "    ON UPDATE RESTRICT ON DELETE CASCADE\n" +
            ");\n";
    private static final String CREATE_PROJECT = "CREATE TABLE \"project\" (\n" +
            "    \"id\"                           BIGSERIAL   PRIMARY KEY,\n" +
            "    \"name\"                         TEXT     NOT NULL,\n" +
            "    \"date_of_beginning\"            DATE     NOT NULL,\n" +
            "    \"date_of_ending\"               DATE,\n" +
            "    \"customer_id\"                  BIGINT   NOT NULL,\n" +
            "\n" +
            "    CONSTRAINT project_customer_id_fk FOREIGN KEY (customer_id) REFERENCES customer (id)\n" +
            "    ON UPDATE RESTRICT\n" +
            "    ON DELETE CASCADE\n" +
            ");";
    private static final String CREATE_REQUIREMENTS = "CREATE TABLE \"requirements\" (\n" +
            "    \"id\"                           BIGSERIAL   PRIMARY KEY,\n" +
            "    \"requirement_text\"             TEXT     NOT NULL,\n" +
            "    \"date_of_beginning\"            DATE,\n" +
            "    \"planned_time\"                 TIME     NOT NULL,\n" +
            "    \"priority_of_execution_time\"   PRIORITY_ENUM NOT NULL,\n" +
            "    \"criticality_level\"            PRIORITY_ENUM NOT NULL,\n" +
            "    \"completion_mark\"              MARK_ENUM,\n" +
            "    \"probability_of_change\"        PROBABILITY_ENUM NOT NULL,\n" +
            "    \"project_id\"                   BIGINT   NOT NULL,\n" +
            "    \n" +
            "    CONSTRAINT project_id_fk FOREIGN KEY (project_id) REFERENCES project (id)\n" +
            "    ON UPDATE RESTRICT\n" +
            "    ON DELETE CASCADE\n" +
            ");";
    private static final String CREATE_SCHEDULED_TESTS = "CREATE TABLE \"scheduled_tests\" (\n" +
            "    \"id\"                           BIGSERIAL  PRIMARY KEY,\n" +
            "    \"description_of_execution\"     TEXT       NOT NULL,\n" +
            "    \"expected_result\"              TEXT       NOT NULL,\n" +
            "    \"planned_execution_time\"       TIME       NOT NULL,\n" +
            "    \"test_level\"                   LEVEL_ENUM NOT NULL,\n" +
            "    \"requirement_id\"               BIGINT     NOT NULL,\n" +
            "    \n" +
            "    CONSTRAINT requirement_id_fk FOREIGN KEY (requirement_id) REFERENCES requirements (id)\n" +
            "    ON UPDATE RESTRICT\n" +
            "    ON DELETE CASCADE\n" +
            ");";
    private static final String CREATE_PERFORMED_TESTS = "CREATE TABLE \"performed_tests\" (\n" +
            "    \"id\"                           BIGSERIAL   PRIMARY KEY,\n" +
            "    \"datetime_of_beginning\"        TIMESTAMP   NOT NULL,\n" +
            "    \"execution_time\"               TIME        NOT NULL,\n" +
            "    \"result\"                       RESULT_ENUM NOT NULL,\n" +
            "    \"scheduled_test_id\"            BIGINT      NOT NULL,\n" +
            "    \n" +
            "    CONSTRAINT scheduled_test_id_fk FOREIGN KEY (scheduled_test_id) REFERENCES scheduled_tests (id)\n" +
            "    ON UPDATE RESTRICT\n" +
            "    ON DELETE CASCADE\n" +
            ");";

    private AllTablesDAO() {
    }

    public static void setAllTables(){
        setCreatePriorityEnum();
        setCreateProbabilityEnum();
        setCreateMarkEnum();
        setCreateLevelEnum();
        setCreateResultEnum();
        setCreateUsers();
        setCreateCustomer();
        setCreatePhone();
        setCreateEmail();
        setCreateCustomerContactPerson();
        setCreateProject();
        setCreateRequirements();
        setCreateScheduledTests();
        setCreatePerformedTests();
    }

    private static void execute(String sql){
        try {
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setCreatePriorityEnum() {
        execute(CREATE_PRIORITY_ENUM);
    }
    public static void setCreateProbabilityEnum() {
        execute(CREATE_PROBABILITY_ENUM);
    }
    public static void setCreateMarkEnum() {
        execute(CREATE_MARK_ENUM);
    }
    public static void setCreateLevelEnum() {
        execute(CREATE_LEVEL_ENUM);
    }
    public static void setCreateResultEnum() {
        execute(CREATE_RESULT_ENUM);
    }
    public static void setCreateUsers(){
        execute(CREATE_USERS);
    }
    public static void setCreateCustomer(){
        execute(CREATE_CUSTOMER);
    }
    public static void setCreateCustomerContactPerson(){
        execute(CREATE_CUSTOMER_CONTACT_PERSON);
    }
    public static void setCreatePhone(){
        execute(CREATE_PHONE);
    }
    public static void setCreateEmail(){
        execute(CREATE_EMAIL);
    }
    public static void setCreateProject(){
        execute(CREATE_PROJECT);
    }
    public static void setCreateRequirements(){
        execute(CREATE_REQUIREMENTS);
    }
    public static void setCreateScheduledTests(){
        execute(CREATE_SCHEDULED_TESTS);
    }
    public static void setCreatePerformedTests(){
        execute(CREATE_PERFORMED_TESTS);
    }
}
