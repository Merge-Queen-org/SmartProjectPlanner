package dk.ek.smartprojectplanner.repository;

import dk.ek.smartprojectplanner.model.Subtask;
import dk.ek.smartprojectplanner.model.Task;
import dk.ek.smartprojectplanner.rowMapper.TaskRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // User story 5: Opret opgave
    public void createTask(Task task) {
        // gem ny opgave
        String sql = "INSERT INTO task (subproject_id, task_name, task_description, " +
                "task_estimated_hours, task_start_date, task_due_date) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                task.getSubprojectId(),
                task.getTaskName(),
                task.getTaskDescription(),
                task.getTaskEstimatedHours(),
                task.getTaskStartDate(),
                task.getTaskDueDate());
    }

    // henter en task ud fra id
    public Task findTaskById(int taskId) {
        String sql = "SELECT * FROM task WHERE task_id = ?";
        return jdbcTemplate.queryForObject(sql, new TaskRowMapper(), taskId);
    }

    // gemmer ændringerne
    public void updateTask(Task task) {
        String sql = "UPDATE task SET task_name = ?, task_description = ?, task_estimated_hours = ?, " +
                "task_start_date = ?, task_due_date = ? WHERE task_id = ?";
        jdbcTemplate.update(sql, task.getTaskName(), task.getTaskDescription(), task.getTaskEstimatedHours(),
                task.getTaskStartDate(), task.getTaskDueDate(), task.getTaskId());
    }

    // gemmer en ny subtask under en task
    public void createSubtask(Subtask subtask) {
        String sql = "INSERT INTO subtask (task_id, subtask_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, subtask.getTaskId(), subtask.getSubtaskName());
    }

    // henter alle tasks for et subprojekt
    public List<Task> findTasksBySubprojectId(int subprojectId) {
        String sql = "SELECT * FROM task WHERE subproject_id = ?";
        return jdbcTemplate.query(sql, new TaskRowMapper(), subprojectId);
    }
}
