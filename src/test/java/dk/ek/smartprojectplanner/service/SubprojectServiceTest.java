package dk.ek.smartprojectplanner.service;

import dk.ek.smartprojectplanner.model.Project;
import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.repository.SubprojectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SubprojectServiceTest {

    @Mock
    private SubprojectRepository subprojectRepository;

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private SubprojectService subprojectService;

    @Test
    void saveNewSubproject_setsProjectIdAndSavesSubproject(){
        Subproject subproject = new Subproject(1,2,"Design","Prototyping");

        subprojectService.saveNewSubproject(1, subproject);

        assertEquals(1,subproject.getProjectId());
        verify(subprojectRepository).saveNewSubproject(subproject);
    }

    @Test
    void getSubprojects_returnSubproject(){
        Subproject subproject = new Subproject(0,2,"","");
        subprojectService.getSubprojects(2);

        assertEquals(2, subproject.getProjectId());
        verify(projectService).getSubProjectsByProjectId(2);
    }

}
