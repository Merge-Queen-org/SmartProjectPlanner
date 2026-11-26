package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.model.Project;
import dk.ek.smartprojectplanner.service.ProjectService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/projects")
    public String showProjects(Model model) {

        model.addAttribute(
                "projects",
                projectService.getAllProjectSummaries()
        );

        return "projects";
    }

    @GetMapping("/projects/{projectId}/subprojects")
    public String getSubProjects(@PathVariable int projectId, Model model) {

        model.addAttribute("subprojects",
                projectService.getSubProjectsByProjectId(projectId));

        return "subprojects";
    }
    // User story: Delete project
    @PostMapping("/projects/{projectId}/delete")
    public String deleteProject(@PathVariable int projectId) {
        projectService.deleteProject(projectId);
        return "redirect:/projects";
    }

    // User story: Edit project
    @GetMapping("/projects/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Project project = projectService.getProjectById(id);
        if (project == null) return "redirect:/projects";
        model.addAttribute("project", project);
        return "editProjects";
    }

    //Save edited project
    @PostMapping("/projects/edit/{id}")
    public String editProject(@PathVariable int id, @ModelAttribute Project project) {
        projectService.editProject(id, project);
        return "redirect:/projects";
    }


}
