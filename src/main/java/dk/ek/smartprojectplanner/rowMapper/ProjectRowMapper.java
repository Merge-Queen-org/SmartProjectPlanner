package dk.ek.smartprojectplanner.rowMapper;

import dk.ek.smartprojectplanner.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class ProjectRowMapper implements RowMapper<Project> {

        @Override
        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new Project(
                    rs.getInt("project_id"),
                    rs.getInt("office_id"),
                    rs.getString("project_name"),
                    rs.getString("project_description"),
                    rs.getDate("project_start_date").toLocalDate(),
                    rs.getDate("project_deadline").toLocalDate()
            );
        }
    }

