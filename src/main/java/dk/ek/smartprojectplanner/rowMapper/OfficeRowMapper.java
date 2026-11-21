package dk.ek.smartprojectplanner.rowMapper;

import dk.ek.smartprojectplanner.model.Office;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficeRowMapper implements RowMapper<Office> {

    @Override
    public Office mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Office(
                rs.getInt("office_id"),
                rs.getString("office_name"),
                rs.getString("office_country")
        );
    }
}
