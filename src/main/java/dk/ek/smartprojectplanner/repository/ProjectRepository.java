package dk.ek.smartprojectplanner.repository;

import dk.ek.smartprojectplanner.model.Project;
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

    // User story 2: See all projects
    public List<Project> findAllProjects() {

        String sql = """
        SELECT
            project_id,
            project_name,
            project_description,
            project_start_date,
            project_deadline
        FROM project
        ORDER BY project_id
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Project(
                        rs.getInt("project_id"),
                        rs.getInt("office_id"),
                        rs.getString("project_name"),
                        rs.getString("project_description"),
                        rs.getDate("project_start_date").toLocalDate(),
                        rs.getDate("project_deadline").toLocalDate()
                )
        );
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

    // User story: Edit project
    // Find one project by ID
    public Project findProjectsByProjectId(int projectId) {

        String sql = """
        SELECT *
        FROM project
        WHERE project_id = ?
        """;

        List<Project> projects = jdbcTemplate.query(sql, (rs, rowNum) ->
                        new Project(
                                rs.getInt("project_id"),
                                rs.getInt("office_id"),
                                rs.getString("project_name"),
                                rs.getString("project_description"),
                                rs.getDate("project_start_date").toLocalDate(),
                                rs.getDate("project_deadline").toLocalDate()
                        ),
                projectId
        );

        return projects.isEmpty() ? null : projects.get(0);
    }
    // Update an existing project
    public void editProject(int projectId, Project project) {

        String sql = """
        UPDATE project
        SET office_id = ?,
            project_name = ?,
            project_description = ?,
            project_start_date = ?,
            project_deadline = ?
        WHERE project_id = ?
        """;

        jdbcTemplate.update(
                sql,
                project.getOfficeId(),
                project.getProjectName(),
                project.getProjectDescription(),
                project.getProjectStartDate(),
                project.getProjectDeadline(),
                projectId
        );
    }




}
