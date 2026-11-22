package dk.ek.smartprojectplanner.rowMapper;

import dk.ek.smartprojectplanner.model.Subproject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubprojectRowMapper implements RowMapper<Subproject> {

    @Override
    public Subproject mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Subproject(
                rs.getInt("subproject_id"),
                rs.getInt("project_id"),
                rs.getString("subproject_name"),
                rs.getString("subproject_description")
        );
    }
}
