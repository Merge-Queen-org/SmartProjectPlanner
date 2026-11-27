package dk.ek.smartprojectplanner.service;

import dk.ek.smartprojectplanner.model.Task;
import dk.ek.smartprojectplanner.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // User story 5: Opret opgave
    public void createTask(Task task) {
        // send videre til repository
        taskRepository.createTask(task);
    }
}