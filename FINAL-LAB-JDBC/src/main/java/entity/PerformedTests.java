package entity;

import types.ResultEnum;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PerformedTests {
    private int id;
    private LocalDateTime datetimeOfBeginning;
    private LocalTime executionTime;
    private ResultEnum result; // Enum для RESULT_ENUM
    private int scheduledTestId;

    public PerformedTests(int id, LocalDateTime datetimeOfBeginning, LocalTime executionTime, ResultEnum result, int scheduledTestId) {
        this.id = id;
        this.datetimeOfBeginning = datetimeOfBeginning;
        this.executionTime = executionTime;
        this.result = result;
        this.scheduledTestId = scheduledTestId;
    }

    public PerformedTests() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDatetimeOfBeginning() {
        return datetimeOfBeginning;
    }

    public void setDatetimeOfBeginning(LocalDateTime datetimeOfBeginning) {
        this.datetimeOfBeginning = datetimeOfBeginning;
    }

    public LocalTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalTime executionTime) {
        this.executionTime = executionTime;
    }

    public ResultEnum getResult() {
        return result;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    public int getScheduledTestId() {
        return scheduledTestId;
    }

    public void setScheduledTestId(int scheduledTestId) {
        this.scheduledTestId = scheduledTestId;
    }

    @Override
    public String toString() {
        return "PerformedTests{" +
                "id=" + id +
                ", datetimeOfBeginning=" + datetimeOfBeginning +
                ", executionTime=" + executionTime +
                ", result=" + result +
                ", scheduledTestId=" + scheduledTestId +
                '}';
    }
}
