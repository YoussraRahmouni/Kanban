/**
 * 
 */
package org.tse.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tse.kanban.entities.Task;
import org.tse.kanban.services.TaskService;

/**
 * @author Rahmouni Youssra
 *
 */
@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return this.taskService.findAllTasks();
	}
	
	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task newTask) {
		return this.taskService.createTask(newTask);	
	}
	
	@GetMapping("/task/{id}")
	public Task getTask(@PathVariable Long id) {
		return this.taskService.findTask(id);
	}
	
	@PatchMapping("/task/{id}")
	void moveTask(@RequestBody String moveTask, Task task) {
		if (moveTask == "moveright") {
			this.taskService.moveRight(task);
		}	
		if (moveTask == "moveleft") {
			this.taskService.moveLeft(task);
		}
	}
	
}
