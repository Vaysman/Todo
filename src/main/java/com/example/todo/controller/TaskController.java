package com.example.todo.controller;

import com.example.todo.Entities.Task;
import com.example.todo.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
    private int counter = 4;

    //@Autowired
   // private TaskService taskService;

    public List<Task> GetTasks() {
        return null;
        //return taskService.list();
    }

    @GetMapping("{id}")
    public Task getOne(@PathVariable int id) {
        return getMessage(id);
    }

    private Task getMessage(int id) {
        return GetTasks().stream()
                .filter(message -> message.getId() ==id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Task create(@RequestBody Task message) {
        //message.setId(counter++);

        GetTasks().add(message);

        return message;
    }

    @PutMapping("{id}")
    public Task update(@PathVariable int id, @RequestBody Task message) {
       Task messageFromDb = getMessage(id);

        messageFromDb.setText(message.getText());
        messageFromDb.setDone(message.getDone());

        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Task message = getMessage(id);

        GetTasks().remove(message);
    }
}
