package dk.ek.smartprojectplanner.repository;

import dk.ek.smartprojectplanner.model.Subproject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(SubprojectRepository.class)

public class SubprojectRepositoryTest {

    @Autowired
    SubprojectRepository subprojectRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void saveNewSubproject_addSubproject(){
        Subproject subproject = new Subproject(0,1,"Backend", "API");
        Subproject subproject1 = new Subproject(3,1,"Backend", "Testing");

        subprojectRepository.saveNewSubproject(subproject);
        subprojectRepository.saveNewSubproject(subproject1);

        Integer numberOfSubprojects = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM subproject WHERE project_id = 1",Integer.class);

        assertEquals(4,numberOfSubprojects);
    }
}
