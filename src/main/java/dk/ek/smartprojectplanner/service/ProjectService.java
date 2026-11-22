package dk.ek.smartprojectplanner.service;
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
}
