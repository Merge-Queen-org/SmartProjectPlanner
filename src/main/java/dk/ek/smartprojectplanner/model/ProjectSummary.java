package dk.ek.smartprojectplanner.model;

public class ProjectSummary {

    private Project project;
    private double totalHours;
    private int taskCount;

    public ProjectSummary(Project project, double totalHours, int taskCount) {
        this.project = project;
        this.totalHours = totalHours;
        this.taskCount = taskCount;
    }

    public Project getProject() {
        return project;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public int getTaskCount() {
        return taskCount;
    }
}