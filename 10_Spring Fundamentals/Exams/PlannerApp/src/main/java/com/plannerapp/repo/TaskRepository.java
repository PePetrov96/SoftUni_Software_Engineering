package com.plannerapp.repo;

import com.plannerapp.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.user.id IS NULL")
    List<Task> getAllAvailableTasks();

    @Query("SELECT t FROM Task t WHERE t.user.id = :userId")
    List<Task> getTasksForUser(@Param("userId") Long userId);

    Task findTaskById(Long id);
}
