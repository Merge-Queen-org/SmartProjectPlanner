package dk.ek.smartprojectplanner.rowMapper;

import dk.ek.smartprojectplanner.model.Subtask;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubtaskRowMapper implements RowMapper<Subtask> {

    @Override
    public Subtask mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Subtask(
                rs.getInt("subtask_id"),
                rs.getInt("task_id"),
                rs.getString("subtask_name"),
                rs.getBoolean("subtask_done")
        );
    }
}
