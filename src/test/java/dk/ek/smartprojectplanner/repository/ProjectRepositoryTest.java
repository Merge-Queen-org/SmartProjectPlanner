package dk.ek.smartprojectplanner.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

// starter kun H2-databasen henter vores repository ind

@JdbcTest
@Import(ProjectRepository.class)
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // bruges til at tælle antal rækker

    @Test
    void deleteProject_removesProject() {
        projectRepository.deleteProject(1);

        // slet projekt 1

        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM project", Integer.class);
        assertEquals(1, count);

        // kun 1 projekt er tilbage
    }
}
