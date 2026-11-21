package dk.ek.smartprojectplanner.model;

public class Subtask {
    private int subtaskId;
    private int taskId;
    private String subtaskName;
    private boolean subtaskDone;

    public Subtask(int subtaskId, int taskId, String subtaskName, boolean subtaskDone){
        this.subtaskId = subtaskId;
        this.taskId = taskId;
        this.subtaskName = subtaskName;
        this.subtaskDone =subtaskDone;
    }

    public int getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public Boolean getSubtaskDone() {
        return subtaskDone;
    }

    public void setSubtaskDone(Boolean subtaskDone) {
        this.subtaskDone = subtaskDone;
    }
}
