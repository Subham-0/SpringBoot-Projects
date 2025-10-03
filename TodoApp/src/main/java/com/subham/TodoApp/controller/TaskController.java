package com.subham.TodoApp.controller;

import com.subham.TodoApp.entity.Task;
import com.subham.TodoApp.service.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping()
    public String getTasks(Model model){
        List<Task> tasks = taskServices.getAllTasks();
        model.addAttribute("tasks",tasks);
        System.out.println(tasks);
        return "tasks";
    }
}
