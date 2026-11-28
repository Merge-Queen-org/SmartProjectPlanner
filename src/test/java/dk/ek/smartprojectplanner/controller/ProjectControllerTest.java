package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.model.Project;
import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.service.ProjectService;
import dk.ek.smartprojectplanner.service.SubprojectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// starter kun controlleren

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProjectService projectService;

    @MockitoBean
    private SubprojectService subprojectService;


    // falsk service
    @Test
    void deleteProject_redirectsToFrontPage() throws Exception {

        // tryk på slet bliver sendt videre til forsiden tjekker om servicen er blevet kaldt
        mockMvc.perform(post("/projects/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(projectService).deleteProject(1);
    }

    @Test
    void createSubprojects() throws Exception {
        when(projectService.getProjectById(2)).thenReturn(new Project());

        mockMvc.perform(get("/projects/2/subprojects/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("createSubproject"))
                .andExpect(model().attributeExists("project"));
    }

    @Test
    void createSubproject() throws Exception {

                mockMvc.perform(post("/projects/2/subprojects/create")
                                .param("subprojectName", "Kwan")
                                .param("subprojectDescription", "hckjsgfhw"))

                        .andExpect(status().is3xxRedirection())
                        .andExpect(redirectedUrl("/projects/2/subprojects"));

        verify(subprojectService).saveNewSubproject(eq(2), any(Subproject.class));
    }

    @Test
    void createSubproject_exceptionHandler() throws Exception {
            doThrow(new IllegalAccessException("Name is required"))
                    .when(subprojectService).saveNewSubproject(eq(2), any(Subproject.class));
        when(projectService.getProjectById(2)).thenReturn(new Project());

        mockMvc.perform(post("/projects/2/subprojects/create")
                .param("subprojectName", "Kwan")
                .param("subprojectDescription", "hckjsgfhw"))
                .andExpect(status().isOk())
                .andExpect(view().name("createSubproject"))
                .andExpect(model().attributeExists("project"))
                .andExpect(model().attribute("error", "Name is required"));

    }
}