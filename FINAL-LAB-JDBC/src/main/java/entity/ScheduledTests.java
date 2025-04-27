package entity;

import types.LevelEnum;

import java.time.LocalTime;

public class ScheduledTests {
    private int id;
    private String description_of_execution;
    private String expected_result;
    private LocalTime planned_execution_time;
    private LevelEnum test_level;
    private int requirement_id;

    public ScheduledTests(int id, String description_of_execution, String expected_result, LocalTime planned_execution_time, LevelEnum test_level, int requirement_id) {
        this.id = id;
        this.description_of_execution = description_of_execution;
        this.expected_result = expected_result;
        this.planned_execution_time = planned_execution_time;
        this.test_level = test_level;
        this.requirement_id = requirement_id;
    }

    public ScheduledTests() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription_of_execution() {
        return description_of_execution;
    }

    public void setDescription_of_execution(String description_of_execution) {
        this.description_of_execution = description_of_execution;
    }

    public String getExpected_result() {
        return expected_result;
    }

    public void setExpected_result(String expected_result) {
        this.expected_result = expected_result;
    }

    public LocalTime getPlanned_execution_time() {
        return planned_execution_time;
    }

    public void setPlanned_execution_time(LocalTime planned_execution_time) {
        this.planned_execution_time = planned_execution_time;
    }

    public LevelEnum getTest_level() {
        return test_level;
    }

    public void setTest_level(LevelEnum test_level) {
        this.test_level = test_level;
    }

    public int getRequirement_id() {
        return requirement_id;
    }

    public void setRequirement_id(int requirement_id) {
        this.requirement_id = requirement_id;
    }

    @Override
    public String toString() {
        return "ScheduledTests{" +
                "id=" + id +
                ", description_of_execution='" + description_of_execution + '\'' +
                ", expected_result='" + expected_result + '\'' +
                ", planned_execution_time=" + planned_execution_time +
                ", test_level=" + test_level +
                ", requirement_id=" + requirement_id +
                '}';
    }
}
