package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.service.ProjectService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) { // constructor injection
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/projects/{projectId}/subprojects")
    public String getSubProjects(@PathVariable int projectId, Model model) {

        model.addAttribute("subprojects",
                projectService.getSubProjectsByProjectId(projectId));

        return "subprojects";
    }
}
