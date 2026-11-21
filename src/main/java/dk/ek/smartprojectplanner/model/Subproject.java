package dk.ek.smartprojectplanner.model;

public class Subproject {
    private int subprojectId;
    private int projectId;
    private String subprojectName;
    private String subprojectDescription;

    public Subproject(int subprojectId, int projectId, String subprojectName, String subprojectDescription){
        this.subprojectId = subprojectId;
        this.projectId = projectId;
        this.subprojectName = subprojectName;
        this.subprojectDescription = subprojectDescription;
    }

    public int getSubprojectId() {
        return subprojectId;
    }

    public void setSubprojectId(int subprojectId) {
        this.subprojectId = subprojectId;
    }

    public String getSubprojectDescription() {
        return subprojectDescription;
    }

    public void setSubprojectDescription(String subprojectDescription) {
        this.subprojectDescription = subprojectDescription;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getSubprojectName() {
        return subprojectName;
    }

    public void setSubprojectName(String subprojectName) {
        this.subprojectName = subprojectName;
    }
}
