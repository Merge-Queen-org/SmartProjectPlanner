package dk.ek.smartprojectplanner.repository;

import dk.ek.smartprojectplanner.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
