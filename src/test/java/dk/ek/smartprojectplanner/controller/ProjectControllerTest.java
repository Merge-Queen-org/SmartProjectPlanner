package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectController.class)    // starter kun controlleren
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;            // falsk browser

    @MockitoBean
    private ProjectService projectService;   // falsk service

    @Test
    void deleteProject_redirectsToFrontPage() throws Exception {
        mockMvc.perform(post("/projects/1/delete"))     // tryk på slet
                .andExpect(status().is3xxRedirection()) // bliver sendt videre
                .andExpect(redirectedUrl("/"));         // til forsiden

        verify(projectService).deleteProject(1);        // tjek at service blev kaldt
    }
}