package com.example.todo.service;

import com.example.todo.dto.TaskDTO;
import com.example.todo.entities.Task;
import com.example.todo.repo.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
  @NonNull
  private final TaskRepository taskRepository;

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public Task getTask(long id) {
    return taskRepository.getOne(id);
  }

  public Task createTask(TaskDTO taskDto) {
    Task task = new Task();
    task.setText(taskDto.getText());
    task.setDone(taskDto.isDone());
    return taskRepository.save(task);
  }

  public Task saveTask(Task task) {
    return taskRepository.save(task);
  }

  public void deleteTask(long id) {
    taskRepository.deleteById(id);
  }
}
