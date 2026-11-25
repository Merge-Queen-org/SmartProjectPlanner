package dk.ek.smartprojectplanner.model;

public class ProjectSummary {

    private Project project;
    private double totalHours;
    private double remainingHours;
    private int taskCount;
    private int workingDaysUntilDeadline;
    private double hoursPerWorkingDay;
    private String risk;

    public ProjectSummary(Project project,
                          double totalHours,
                          double remainingHours,
                          int taskCount,
                          int workingDaysUntilDeadline,
                          double hoursPerWorkingDay,
                          String risk) {
        this.project = project;
        this.totalHours = totalHours;
        this.remainingHours = remainingHours;
        this.taskCount = taskCount;
        this.workingDaysUntilDeadline = workingDaysUntilDeadline;
        this.hoursPerWorkingDay = hoursPerWorkingDay;
        this.risk = risk;
    }

    public Project getProject() {
        return project;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public double getRemainingHours() {
        return remainingHours;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public int getWorkingDaysUntilDeadline() {
        return workingDaysUntilDeadline;
    }

    public double getHoursPerWorkingDay() {
        return hoursPerWorkingDay;
    }

    public String getRisk() {
        return risk;
    }
}