package dk.ek.smartprojectplanner.controller;

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
        return "redirect:/";
        // tilbage til forsiden
    }
}