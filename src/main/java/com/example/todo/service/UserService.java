package com.example.todo.service;

import com.example.todo.entities.Task;
import com.example.todo.entities.User;
import com.example.todo.repo.TaskRepository;
import com.example.todo.repo.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  @NonNull
  private final TaskRepository tasksRepository;
  @NonNull
  private final UserRepository userRepository;

  public User findUser(String id) {
    return userRepository.findAllByName(id).get(0);
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }

  public void deleteUser(User user) {
    userRepository.delete(user);
  }

  public void updateUser(User user) {
    userRepository.save(user);
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  public List<Task> findAllTasks() {
    return tasksRepository.findAll();
  }
}
