package com.subham.TodoApp.controller;

import com.subham.TodoApp.entity.Task;
import com.subham.TodoApp.service.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping()
    public String getTasks(Model model) {
        List<Task> tasks = taskServices.getAllTasks();
        model.addAttribute("tasks", tasks);
//        System.out.println(tasks);
        return "tasks";
    }

    @PostMapping
    public String create(@RequestParam String title) {
        taskServices.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskServices.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskServices.toggleTask(id);
        return "redirect:/";
    }
}
