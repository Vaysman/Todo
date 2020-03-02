package com.example.todo;

import com.example.todo.Entities.Role;
import com.example.todo.Entities.Task;
import com.example.todo.Entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.UserService;

import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		UserService userService = new UserService();
		//User user1 = userService.findUser("вова");

		List users = userService.findAllTasks();
		int a =0;
		//System.out.println(users.get(0).getTasks().get(0).getText());
	}
}
