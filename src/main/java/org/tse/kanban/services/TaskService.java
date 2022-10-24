/**
 * 
 */
package org.tse.kanban.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tse.kanban.entities.Task;
import org.tse.kanban.entities.TaskStatus;
import org.tse.kanban.entities.TaskType;
import org.tse.kanban.repository.ITask;
import org.tse.kanban.repository.ITaskType;

/**
 * @author Rahmouni Youssra
 *
 */
@Service
public class TaskService {
	
	@Autowired
	private ITask taskRepo;
	@Autowired
	private ITaskType taskTypeRepo;
	
	private List<TaskType> tasksTypes = taskTypeRepo.findAll();
	
	public void createTask(Task task) {
		taskRepo.save(task);
	}
	
	public List<Task> findAllTasks(){
		return taskRepo.findAll();
	}
	
	public Task findTask(long id) {
		return taskRepo.findById(id).get();
	}
	
	public void deleteTask(long id) {
		taskRepo.deleteById(id);
	}
	
	
	public void moveRight(Task task) {
		TaskStatus taskStatus = task.getTaskStatus();
		String currentStateLabel = task.getTaskStatus().getLabel();
		
		tasksTypes.forEach( taskType -> {
			if (taskType.getLabel() == currentStateLabel) {
				TaskType nextType = taskTypeRepo.findById(taskType.getId()+1).get();
				taskStatus.setLabel(nextType.getLabel());
				task.setTaskStatus(taskStatus);
			}
		
		});		
	}
	
	public void moveLeft(Task task) {
		TaskStatus taskStatus = task.getTaskStatus();
		String currentStateLabel = task.getTaskStatus().getLabel();
		
		tasksTypes.forEach( taskType -> {
			if (taskType.getLabel() == currentStateLabel) {
				TaskType nextType = taskTypeRepo.findById(taskType.getId()-1).get();
				taskStatus.setLabel(nextType.getLabel());
				task.setTaskStatus(taskStatus);
			}
		
		});	

	}

}
