package com.task.task_project.service;

import com.task.task_project.model.Task;
import com.task.task_project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setPriority(taskDetails.getPriority());
            task.setDueDate(taskDetails.getDueDate());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        }
        return null;
    }
    
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }
    
    public List<Task> getTasksByPriority(Task.Priority priority) {
        return taskRepository.findByPriority(priority);
    }
    
    // ACTUALIZADO para usar LocalDate (solo fecha para búsquedas)
    public List<Task> getTasksByDueDate(LocalDate dueDate) {
        LocalDateTime startOfDay = dueDate.atStartOfDay();
        LocalDateTime endOfDay = dueDate.atTime(23, 59, 59);
        return taskRepository.findByDueDateBetween(startOfDay, endOfDay);
    }
    
    // ACTUALIZADO para usar LocalDateTime en consultas
    public List<Task> getTasksByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        return taskRepository.findByDueDateBetween(startDateTime, endDateTime);
    }
    
    // ACTUALIZADO para usar LocalDateTime
    public List<Task> getOverdueTasks() {
        return taskRepository.findByCompletedFalseAndDueDateBefore(LocalDateTime.now());
    }
    
    public List<Task> searchTasks(String keyword) {
        return taskRepository.searchTasks(keyword);
    }
    
    public Task toggleTaskCompletion(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(!task.isCompleted());
            return taskRepository.save(task);
        }
        return null;
    }
}