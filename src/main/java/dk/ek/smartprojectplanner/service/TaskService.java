package dk.ek.smartprojectplanner.service;

import dk.ek.smartprojectplanner.model.Subtask;
import dk.ek.smartprojectplanner.model.Task;
import dk.ek.smartprojectplanner.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // henter en task
    public Task findTaskById(int taskId) {
        return taskRepository.findTaskById(taskId);
    }

    // gemmer ændringer
    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    // gemmer en ny subtask
    public void createSubtask(Subtask subtask) {
        taskRepository.createSubtask(subtask);
    }

    // henter alle tasks for et subprojekt
    public List<Task> findTasksBySubprojectId(int subprojectId) {
        return taskRepository.findTasksBySubprojectId(subprojectId);
    }
}