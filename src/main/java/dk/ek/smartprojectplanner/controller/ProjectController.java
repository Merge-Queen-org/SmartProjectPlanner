package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.model.Project;
import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.service.ProjectService;
import dk.ek.smartprojectplanner.service.SubprojectService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    private final ProjectService projectService;
    private final SubprojectService subProjectService;

    public ProjectController(ProjectService projectService, SubprojectService subprojectService) { // constructor injection
        this.projectService = projectService;
        this.subProjectService = subprojectService;
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

        model.addAttribute("projectId", projectId);

        model.addAttribute("project",
                projectService.getProjectById(projectId));

        return "seeAllSubprojects";
    }

    // viser "er du sikker?" siden
    @GetMapping("/projects/{projectId}/delete")
    public String showDeleteProject(@PathVariable int projectId, Model model) {
        model.addAttribute("project", projectService.getProjectById(projectId));
        return "delete-project";
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

    @GetMapping("/overview")
    public String showOverview() {
        return "overview";
    }

    @GetMapping("/projects/{projectId}/subprojects/create")
    public String createSubprojects(@PathVariable int projectId, Model model) {
        model.addAttribute("subprojects", projectId);
        return "createSubproject";
    }

    @PostMapping("/projects/{projectId}/subprojects/create")
    public String createSubproject(@PathVariable int projectId, @RequestParam String subprojectName,
                                   @RequestParam(required = false) String subprojectDescription) {
        Subproject subproject = new Subproject(0, projectId, subprojectName, subprojectDescription);
        subProjectService.saveNewSubproject(projectId, subproject);
        return "redirect:/projects/" + projectId + "/subprojects";
    }

}
