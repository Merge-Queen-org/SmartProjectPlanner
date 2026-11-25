package dk.ek.smartprojectplanner.service;

import dk.ek.smartprojectplanner.model.Project;
import dk.ek.smartprojectplanner.model.ProjectSummary;
import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Subproject> getSubProjectsByProjectId(int projectId) {
        return projectRepository.findSubprojectsByProjectId(projectId);
    }

    public void deleteProject(int projectId) {
        projectRepository.deleteProject(projectId);
    }


    public Project getProjectById(int projectId) {
        return projectRepository.findProjectsByProjectId(projectId);
    }

    public void editProject(int projectId, Project project) {
        projectRepository.editProject(projectId, project);
    }

    public List<ProjectSummary> getAllProjectSummaries() {
        List<Project> projects = projectRepository.findAllProjects();


        return null;
    }
}
