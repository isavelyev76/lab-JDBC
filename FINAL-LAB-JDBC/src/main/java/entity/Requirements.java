package entity;

import types.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Requirements {
    private int id;
    private String requirementText;
    private LocalDate dateOfBeginning;
    private LocalTime plannedTime;
    private PriorityEnum priorityOfExecutionTime;
    private PriorityEnum criticalityLevel;
    private MarkEnum completionMark;
    private ProbabilityEnum probabilityOfChange;
    private int projectId;

    public Requirements(int id, String requirementText, LocalDate dateOfBeginning, LocalTime plannedTime, PriorityEnum priorityOfExecutionTime, PriorityEnum criticalityLevel, MarkEnum completionMark, ProbabilityEnum probabilityOfChange, int projectId) {
        this.id = id;
        this.requirementText = requirementText;
        this.dateOfBeginning = dateOfBeginning;
        this.plannedTime = plannedTime;
        this.priorityOfExecutionTime = priorityOfExecutionTime;
        this.criticalityLevel = criticalityLevel;
        this.completionMark = completionMark;
        this.probabilityOfChange = probabilityOfChange;
        this.projectId = projectId;
    }

    public Requirements() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementText() {
        return requirementText;
    }

    public void setRequirementText(String requirementText) {
        this.requirementText = requirementText;
    }

    public LocalDate getDateOfBeginning() {
        return dateOfBeginning;
    }

    public void setDateOfBeginning(LocalDate dateOfBeginning) {
        this.dateOfBeginning = dateOfBeginning;
    }

    public LocalTime getPlannedTime() {
        return plannedTime;
    }

    public void setPlannedTime(LocalTime plannedTime) {
        this.plannedTime = plannedTime;
    }

    public PriorityEnum getPriorityOfExecutionTime() {
        return priorityOfExecutionTime;
    }

    public void setPriorityOfExecutionTime(PriorityEnum priorityOfExecutionTime) {
        this.priorityOfExecutionTime = priorityOfExecutionTime;
    }

    public PriorityEnum getCriticalityLevel() {
        return criticalityLevel;
    }

    public void setCriticalityLevel(PriorityEnum criticalityLevel) {
        this.criticalityLevel = criticalityLevel;
    }

    public MarkEnum getCompletionMark() {
        return completionMark;
    }

    public void setCompletionMark(MarkEnum completionMark) {
        this.completionMark = completionMark;
    }

    public ProbabilityEnum getProbabilityOfChange() {
        return probabilityOfChange;
    }

    public void setProbabilityOfChange(ProbabilityEnum probabilityOfChange) {
        this.probabilityOfChange = probabilityOfChange;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Requirements{" +
                "id=" + id +
                ", requirementText='" + requirementText + '\'' +
                ", dateOfBeginning=" + dateOfBeginning +
                ", plannedTime=" + plannedTime +
                ", priorityOfExecutionTime=" + priorityOfExecutionTime +
                ", criticalityLevel=" + criticalityLevel +
                ", completionMark=" + completionMark +
                ", probabilityOfChange=" + probabilityOfChange +
                ", projectId=" + projectId +
                '}';
    }
}
