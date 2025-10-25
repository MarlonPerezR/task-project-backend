package com.task.task_project.repository;

import com.task.task_project.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByCompleted(boolean completed);
    List<Task> findByPriority(Task.Priority priority);
    
    // ACTUALIZADO para LocalDateTime
    List<Task> findByDueDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    // ACTUALIZADO para LocalDateTime
    List<Task> findByCompletedFalseAndDueDateBefore(LocalDateTime date);
    
    @Query("SELECT t FROM Task t WHERE " +
           "LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Task> searchTasks(@Param("keyword") String keyword);
    
    // Método anterior eliminado ya que no es compatible con LocalDateTime

}