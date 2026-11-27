package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.service.ProjectService;
import dk.ek.smartprojectplanner.service.SubprojectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}