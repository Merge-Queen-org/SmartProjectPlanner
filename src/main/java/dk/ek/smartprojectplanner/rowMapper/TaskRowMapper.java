package dk.ek.smartprojectplanner.rowMapper;

import dk.ek.smartprojectplanner.model.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Task(
                rs.getInt("task_id"),
                rs.getInt("subproject_id"),
                rs.getInt("employee_id"),
                rs.getString("task_name"),
                rs.getString("task_description"),
                rs.getInt("task_estimated_hours"),
                rs.getDate("task_start_date").toLocalDate(),
                rs.getDate("task_due_date").toLocalDate()
        );
    }
}