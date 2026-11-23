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
        Subproject subproject = new Subproject(0,2,"Backend", "API");

        subprojectRepository.saveNewSubproject(subproject);

        Integer numberOfSubprojects = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM subproject",Integer.class);
        assertEquals(1,numberOfSubprojects);
    }
}
