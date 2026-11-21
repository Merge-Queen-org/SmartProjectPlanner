package dk.ek.smartprojectplanner.model;

import java.time.LocalDate;

public class Task {
    private int taskId;
    private int subprojectId;
    private int employeeId;
    private String taskName;
    private String taskDescription;
    private int taskEstimatedHours;
    private LocalDate taskStartDate;
    private LocalDate taskDueDate;

    public Task(int taskId, int subprojectId, int employeeId, String taskName, String taskDescription,
           int taskEstimatedHours, LocalDate taskStartDate, LocalDate taskDueDate ){
        this.taskId = taskId;
        this.subprojectId = subprojectId;
        this.employeeId = employeeId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskEstimatedHours = taskEstimatedHours;
        this.taskStartDate = taskStartDate;
        this.taskDueDate = taskDueDate;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getSubprojectId() {
        return subprojectId;
    }

    public void setSubprojectId(int subprojectId) {
        this.subprojectId = subprojectId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskEstimatedHours() {
        return taskEstimatedHours;
    }

    public void setTaskEstimatedHours(int taskEstimatedHours) {
        this.taskEstimatedHours = taskEstimatedHours;
    }

    public LocalDate getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(LocalDate taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }
}
