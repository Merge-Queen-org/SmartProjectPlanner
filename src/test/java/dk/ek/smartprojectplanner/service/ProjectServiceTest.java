package dk.ek.smartprojectplanner.service;

import dk.ek.smartprojectplanner.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

//Mockito er til der er skrevet en falsk repository og en rigtig service

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void deleteProject_callsRepository() {
        projectService.deleteProject(1);

        // slet projekt 1

        verify(projectRepository).deleteProject(1);

        // tjek at repository blev kaldt
    }
}
