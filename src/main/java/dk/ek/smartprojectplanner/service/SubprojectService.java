package dk.ek.smartprojectplanner.service;

import dk.ek.smartprojectplanner.model.Subproject;
import dk.ek.smartprojectplanner.repository.SubprojectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubprojectService {

    private final SubprojectRepository subprojectRepository;
    private final ProjectService projectService;

    public SubprojectService(SubprojectRepository subprojectRepository,
                             ProjectService projectService) {
        this.subprojectRepository = subprojectRepository;
        this.projectService = projectService;
    }

    public List<Subproject> getSubprojects (int projectId){
        return projectService.getSubProjectsByProjectId(projectId);
    }

    public void saveNewSubproject(int projectId, Subproject subproject){
        validateSubproject(subproject);
        subproject.setProjectId(projectId);
        subprojectRepository.saveNewSubproject(subproject);
    }

    private void validateSubproject(Subproject subproject){
        if (subproject.getSubprojectName() == null || subproject.getSubprojectName().isBlank()){
            throw  new IllegalArgumentException("Name must not be blank");
        }
        if (subproject.getSubprojectName().length() > 100){
            throw new IllegalArgumentException("Name must be at most 100 characters");
        }
        if (subproject.getSubprojectDescription() != null && subproject.getSubprojectDescription().length()>1000){
            throw new IllegalArgumentException("Description must not be more than 1000 characters");
        }
    }

}
