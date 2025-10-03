package com.subham.TodoApp.repo;

import com.subham.TodoApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
