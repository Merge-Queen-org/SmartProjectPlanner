package dk.ek.smartprojectplanner.rowMapper;

import dk.ek.smartprojectplanner.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Employee(
                rs.getInt("employee_id"),
                rs.getString("employee_name")
        );
    }
}
