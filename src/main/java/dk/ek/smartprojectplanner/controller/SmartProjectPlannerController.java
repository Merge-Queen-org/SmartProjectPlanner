package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.repository.SubprojectRepository;
import dk.ek.smartprojectplanner.service.ProjectService;
import dk.ek.smartprojectplanner.service.SubprojectService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmartProjectPlannerController {

    private final ProjectService projectService;
    private final SubprojectService subProjectService;

    public SmartProjectPlannerController(ProjectService projectService,
                                         SubprojectService subprojectService) { // constructor injection
        this.projectService = projectService;
        this.subProjectService = subprojectService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/seeAllProjects")
    public String showAllProjects() {
        return "seeAllProjects";
    }

    @GetMapping("/overview")
    public String showOverview() {
        return "overview";
    }

    @GetMapping("/projects/{projectId}/subprojects")
    public String getSubProjects(@PathVariable int projectId, Model model) {
        model.addAttribute("subprojects",
                projectService.getSubProjectsByProjectId(projectId));
        return "subprojects";
    }

    @GetMapping("/projects/{projectId}/subprojects/create")
    public String createSubprojects(@PathVariable int projectId, Model model){
        model.addAttribute("subprojects", projectId);
        return "createSubproject";
    }

    @PostMapping("/projects/{projectId}/subprojects/create")
    public String createSubproject (@PathVariable int projectId, @RequestParam String subprojectName,
                                    @RequestParam(required = false)String subprojectDescription){
        Subproject subproject = new Subproject(0, projectId, subprojectName, subprojectDescription);
        subProjectService.saveNewSubproject(projectId, subproject);
        return "redirect:/projects/" + projectId + "/createSubproject";
    }

    // User story: Delete project
    @PostMapping("/projects/{projectId}/delete")
    public String deleteProject(@PathVariable int projectId) {
        projectService.deleteProject(projectId);
        return "redirect:/project/";
    }
}
