package dk.ek.smartprojectplanner.repository;

import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.rowMapper.SubprojectRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // User story: See all subprojects
    public List<Subproject> findSubprojectsByProjectId(int projectId) {
        String sql = "SELECT * FROM subproject WHERE project_id = ?";

        return jdbcTemplate.query(
                sql,
                new SubprojectRowMapper(),
                projectId
        );
    }
    // User story: Delete project
    public void deleteProject(int projectId) {
        String sql = "DELETE FROM project WHERE project_id = ?";
        jdbcTemplate.update(sql, projectId);
    }

}
