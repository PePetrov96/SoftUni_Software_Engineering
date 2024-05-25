package com.plannerapp.service;

import com.plannerapp.model.dto.TaskAddBindingModel;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;

import java.util.List;

public interface TaskService {
    void addTask(TaskAddBindingModel taskAddBindingModel);
    List<Task> getAllTasksForUser(User user);
    List<Task> getAllAvailableTasks();
    void assignTask(Long taskId, String username);
    void resignTask(Long taskId);
    void completeTask(Long id);
}
