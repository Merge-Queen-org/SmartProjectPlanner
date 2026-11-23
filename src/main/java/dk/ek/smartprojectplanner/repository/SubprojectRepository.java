package dk.ek.smartprojectplanner.repository;

import dk.ek.smartprojectplanner.model.Subproject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubprojectRepository {
    private final JdbcTemplate jdbcTemplate;

    public SubprojectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveNewSubproject(Subproject subproject){
        String sql = "INSERT INTO subproject(project_id,subproject_name,subproject_description) VALUES (?,?,?)";
        jdbcTemplate.update(sql,subproject.getProjectId(),
                subproject.getSubprojectName(),
                subproject.getSubprojectDescription()
        );
    }
}
