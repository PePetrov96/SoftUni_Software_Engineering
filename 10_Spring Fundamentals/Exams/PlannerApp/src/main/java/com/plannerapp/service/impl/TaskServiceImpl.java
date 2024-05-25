package com.plannerapp.service.impl;

import com.plannerapp.model.dto.TaskAddBindingModel;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.model.entity.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, PriorityRepository priorityRepository,
                           UserRepository userRepository, UserRepository userRepository1, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userRepository = userRepository1;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTask(TaskAddBindingModel taskAddBindingModel) {
        Task task = this.modelMapper.map(taskAddBindingModel, Task.class);

        PriorityName priorityName = PriorityName.valueOf(taskAddBindingModel.getPriority().toUpperCase());
        Priority priority = this.priorityRepository.findFirstByName(priorityName);

        task.setPriority(priority);

        this.taskRepository.saveAndFlush(task);
    }

    @Override
    public List<Task> getAllTasksForUser(User user) {
        return this.taskRepository.getTasksForUser(user.getId());
    }

    @Override
    public List<Task> getAllAvailableTasks() {
        return this.taskRepository.getAllAvailableTasks();
    }

    @Override
    public void assignTask(Long taskId, String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        Task task = this.taskRepository.findTaskById(taskId);

        user.ifPresent(task::assignUser);

        this.taskRepository.saveAndFlush(task);
    }

    @Override
    public void resignTask(Long taskId) {
        Task task = this.taskRepository.findTaskById(taskId);

        task.resignUser();

        this.taskRepository.saveAndFlush(task);
    }

    @Override
    public void completeTask(Long id) {
        Task task = this.taskRepository.findTaskById(id);
        this.taskRepository.delete(task);
    }
}
