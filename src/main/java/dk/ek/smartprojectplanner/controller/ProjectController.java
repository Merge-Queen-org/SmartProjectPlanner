package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.model.Project;
import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.service.ProjectService;
import dk.ek.smartprojectplanner.service.SubprojectService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

    private final ProjectService projectService;
    private final SubprojectService subprojectService;

    public ProjectController(ProjectService projectService, SubprojectService subprojectService) { // constructor injection
        this.projectService = projectService;
        this.subprojectService = subprojectService;
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
    @GetMapping("/overview")
    public String showOverview() {
        return "overview";
    }

    @GetMapping("/projects/{projectId}/subprojects/create")
    public String createSubprojects(@PathVariable int projectId, Model model){
        Project project = projectService.getProjectById(projectId);
        if (project == null) return "redirect:/projects";
        model.addAttribute("project", project);
        return "createSubproject";
    }

    @PostMapping("/projects/{projectId}/subprojects/create")
    public String createSubproject (@PathVariable int projectId,
                                    @RequestParam String subprojectName,
                                    @RequestParam(required = false) String subprojectDescription,
                                    Model model) {

        Subproject subproject = new Subproject(0, projectId, subprojectName, subprojectDescription);
        try {
            subprojectService.saveNewSubproject(projectId, subproject);
            return "redirect:/projects/" + projectId + "/subprojects";
        } catch (IllegalArgumentException exception) {
            model.addAttribute("project", projectService.getProjectById(projectId));
            model.addAttribute("error", exception.getMessage());
            return "createSubproject";
        }
    }
    // User story: Delete project
    @PostMapping("/projects/{projectId}/delete")
    public String deleteProject(@PathVariable int projectId) {
        projectService.deleteProject(projectId);
        return "redirect:/";
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
