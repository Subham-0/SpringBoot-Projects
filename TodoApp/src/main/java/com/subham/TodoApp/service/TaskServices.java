package com.subham.TodoApp.service;

import com.subham.TodoApp.entity.Task;
import com.subham.TodoApp.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    private final TaskRepo taskRepo;

    public TaskServices(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setComplete(false);
        taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);

    }

    public void toggleTask(Long id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid task"));
        task.setComplete(!task.isComplete());
        taskRepo.save(task);
    }
}
