package dk.ek.smartprojectplanner.service;

import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.repository.SubprojectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        Subproject subproject = new Subproject(1,2,"Design","Prototyping");
        List<Subproject> subprojects = List.of(subproject);
        when(projectService.getSubProjectsByProjectId(2)).thenReturn(subprojects);

        List<Subproject> result = subprojectService.getSubprojects(2);

        assertEquals(subprojects,result);
        verify(projectService).getSubProjectsByProjectId(2);
    }

    @Test
    void getSubproject_returnEmptySubproject(){
        List<Subproject> subprojects = List.of();
        when(projectService.getSubProjectsByProjectId(2)).thenReturn(subprojects);

        List<Subproject> result = subprojectService.getSubprojects(2);

        assertTrue(result.isEmpty());
        verify(projectService).getSubProjectsByProjectId(2);
    }

    @Test
    void saveNewSubproject_throwsWhenNameIsBlank(){
        Subproject subproject = new Subproject(1,2,"  ","Prototyping");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> subprojectService.saveNewSubproject(2, subproject));

        assertEquals("Name must not be blank", exception.getMessage());
        verify(subprojectRepository, never()).saveNewSubproject(any());
    }

    @Test
    void saveNewSubproject_throwsWhenNameIsNull(){
        Subproject subproject = new Subproject(1,2,null,"Prototyping");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> subprojectService.saveNewSubproject(2, subproject));

        assertEquals("Name must not be blank", exception.getMessage());
        verify(subprojectRepository, never()).saveNewSubproject(any());
    }
}
