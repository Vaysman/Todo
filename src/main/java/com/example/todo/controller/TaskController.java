package com.example.todo.controller;

import com.example.todo.dto.TaskDTO;
import com.example.todo.entities.Task;
import com.example.todo.service.TaskService;
import com.example.todo.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {
  @NonNull
  private final UserService userService;
  @NonNull
  private final TaskService taskService;

  @GetMapping("{id}")
  public Task getOne(@PathVariable long id) {
    return taskService.getTask(id);
  }

  @PostMapping
  public Task create(@RequestBody TaskDTO message) {
    return taskService.createTask(message);
  }

  @PutMapping("{id}")
  public Task update(@PathVariable long id, @RequestBody TaskDTO message) {
    Task task = taskService.getTask(id);

    task.setDone(message.isDone());
    task.setText(message.getText());

    return taskService.saveTask(task);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable long id) {
    taskService.deleteTask(id);
  }
}

