package com.example.demo.controller;

import com.example.demo.ExceptionHandling.ExceptionHandling;
import com.example.demo.repository.TaskRepository;
import com.example.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        try {
            List<Task> tasks = taskRepository.findAll();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(500).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        try {
            Optional<Task> taskOptional = taskRepository.findById(id);
            if (taskOptional.isPresent()) {
                return ResponseEntity.ok(taskOptional.get());
            } else {
                return ResponseEntity
                        .status(404)
                        .body("Task with ID " + id + " not found");
            }
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            Optional<Task> existingTaskOptional = taskRepository.findById(id);
            if (existingTaskOptional.isPresent()) {
                Task existingTask = existingTaskOptional.get();
                existingTask.setTitle(task.getTitle());
                existingTask.setDescription(task.getDescription());
                existingTask.setCompleted(task.getCompleted());
                Task updatedTask = taskRepository.save(existingTask);
                return ResponseEntity.ok(updatedTask);
            } else {
                return ResponseEntity
                        .status(404)
                        .body("Task with ID " + id + " not found. Cannot update.");
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., validation errors, database constraints)
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            Optional<Task> existingTaskOptional = taskRepository.findById(id);
            if (existingTaskOptional.isPresent()) {
                taskRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity
                        .status(404)
                        .body("Task with ID " + id + " not found. Cannot delete.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}

