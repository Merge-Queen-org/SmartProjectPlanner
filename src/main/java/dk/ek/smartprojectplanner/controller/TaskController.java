package dk.ek.smartprojectplanner.controller;

import dk.ek.smartprojectplanner.model.Subtask;
import dk.ek.smartprojectplanner.model.Task;
import dk.ek.smartprojectplanner.service.TaskService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Vis formularen
    @GetMapping("/subprojects/{subprojectId}/tasks/create")
    public String showCreateTask(@PathVariable int subprojectId, Model model) {
        model.addAttribute("subprojectId", subprojectId);
        return "create-task";
    }

    // Gem opgaven
    @PostMapping("/subprojects/{subprojectId}/tasks/create")
    public String createTask(@PathVariable int subprojectId,
                             @RequestParam String name,
                             @RequestParam(required = false) String description,
                             @RequestParam int hours,
                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
        Task task = new Task(0, subprojectId, 0, name, description, hours, startDate, dueDate);
        // ny opgave
        taskService.createTask(task);
        // gem
        return "redirect:/projects";
        // tilbage til forsiden
    }

    // viser edit-siden med taskens data
    @GetMapping("/tasks/{taskId}/edit")
    public String showEditTask(@PathVariable int taskId, Model model) {
        model.addAttribute("task", taskService.findTaskById(taskId));
        return "edit-task";
    }

    // gemmer ændringerne
    @PostMapping("/tasks/{taskId}/edit")
    public String editTask(@PathVariable int taskId, @RequestParam String name,
                           @RequestParam(required = false) String description, @RequestParam int hours,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {

        // henter den gamle task

        Task task = taskService.findTaskById(taskId);


        task.setTaskName(name);
        task.setTaskDescription(description);
        task.setTaskEstimatedHours(hours);
        task.setTaskStartDate(startDate);
        task.setTaskDueDate(dueDate);
        // gemmer den nye ændring
        taskService.updateTask(task);
        return "redirect:/projects";
    }

    // gemmer en ny subtask og går tilbage til edit-siden
    @PostMapping("/tasks/{taskId}/subtasks/create")
    public String createSubtask(@PathVariable int taskId, @RequestParam String subtaskName) {
        Subtask subtask = new Subtask(0, taskId, subtaskName, false);
        // ny subtask, ikke færdig
        taskService.createSubtask(subtask);
        return "redirect:/tasks/" + taskId + "/edit";
    }

    // viser alle tasks for et subprojekt
    @GetMapping("/subprojects/{subprojectId}/tasks")
    public String showTasks(@PathVariable int subprojectId, Model model) {
        model.addAttribute("tasks", taskService.findTasksBySubprojectId(subprojectId));
        model.addAttribute("subprojectId", subprojectId);
        return "tasks";
    }
}
