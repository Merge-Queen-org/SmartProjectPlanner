package dk.ek.smartprojectplanner.repository;

import dk.ek.smartprojectplanner.model.Project;
import dk.ek.smartprojectplanner.model.ProjectSummary;
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
                        0,
                        rs.getString("project_name"),
                        rs.getString("project_description"),
                        rs.getDate("project_start_date").toLocalDate(),
                        rs.getDate("project_deadline").toLocalDate()
                )
        );
    }

    public List<ProjectSummary> findAllProjectSummaries() {

        String sql = """
        SELECT
            p.project_id,
            p.office_id,
            p.project_name,
            p.project_description,
            p.project_start_date,
            p.project_deadline,
            COALESCE(SUM(t.task_estimated_hours), 0) AS total_hours,
            COUNT(t.task_id) AS task_count
        FROM project p
        LEFT JOIN subproject sp
            ON p.project_id = sp.project_id
        LEFT JOIN task t
            ON sp.subproject_id = t.subproject_id
        GROUP BY
            p.project_id,
            p.office_id,
            p.project_name,
            p.project_description,
            p.project_start_date,
            p.project_deadline
        ORDER BY p.project_id
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Project project = new Project(
                    rs.getInt("project_id"),
                    rs.getInt("office_id"),
                    rs.getString("project_name"),
                    rs.getString("project_description"),
                    rs.getDate("project_start_date").toLocalDate(),
                    rs.getDate("project_deadline").toLocalDate()
            );

            return new ProjectSummary(
                    project,
                    rs.getDouble("total_hours"),
                    rs.getInt("task_count")
            );
        });
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
    // User story: edit project
    public void editProject(int projectId, Project project) {

        String sql = """
        UPDATE project
        SET project_name = ?,
            project_description = ?,
            project_deadline = ?
        WHERE project_id = ?
        """;

        jdbcTemplate.update(
                sql,
                project.getProjectName(),
                project.getProjectDescription(),
                project.getProjectDeadline(),
                projectId
        );
    }



}
