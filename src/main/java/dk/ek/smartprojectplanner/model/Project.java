package dk.ek.smartprojectplanner.model;

import java.time.LocalDate;

public class Project {

    private int projectId;
    private int officeId;
    private String projectName;
    private String projectDescription;
    private LocalDate projectStartDate;
    private LocalDate projectDeadline;

    public Project() {
    }

    public Project(int projectId, int officeId, String projectName,
                   String projectDescription, LocalDate projectStartDate, LocalDate projectDeadline){
        this.projectId = projectId;
        this.officeId = officeId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStartDate = projectStartDate;
        this.projectDeadline = projectDeadline;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public LocalDate getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectDeadline(LocalDate projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
