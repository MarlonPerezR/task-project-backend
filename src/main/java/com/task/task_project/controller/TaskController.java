package com.task.task_project.controller;

import com.task.task_project.model.Task;
import com.task.task_project.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        boolean deleted = taskService.deleteTask(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    

    @GetMapping("/status/{completed}")
    public List<Task> getTasksByStatus(@PathVariable boolean completed) {
        return taskService.getTasksByStatus(completed);
    }

    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable Task.Priority priority) {
        return taskService.getTasksByPriority(priority);
    }
    

    @GetMapping("/due-date/{dueDate}")
    public List<Task> getTasksByDueDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
        return taskService.getTasksByDueDate(dueDate);
    }
    

    @GetMapping("/date-range")
    public List<Task> getTasksByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return taskService.getTasksByDateRange(startDate, endDate);
    }
    
    // GET /api/tasks/overdue - ACTUALIZADO para usar LocalDateTime
    @GetMapping("/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks();
    }
    
    // GET /api/tasks/search
    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String keyword) {
        return taskService.searchTasks(keyword);
    }
    
    // PATCH /api/tasks/{id}/toggle
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTaskCompletion(@PathVariable Long id) {
        Task toggledTask = taskService.toggleTaskCompletion(id);
        return toggledTask != null ? ResponseEntity.ok(toggledTask) : ResponseEntity.notFound().build();
    }
    
    // GET /api/tasks/upcoming - ACTUALIZADO para LocalDateTime
    @GetMapping("/upcoming")
    public List<Task> getUpcomingTasks() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusWeeks(1);
        return taskService.getTasksByDateRange(now.toLocalDate(), nextWeek.toLocalDate());
    }
}