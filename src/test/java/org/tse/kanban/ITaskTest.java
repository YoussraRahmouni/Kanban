package org.tse.kanban;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.tse.kanban.entities.Task;
import org.tse.kanban.repository.ITask;

/**
 * @author Rahmouni Youssra
 *
 */

@DataJpaTest
public class ITaskTest {
	@Autowired
	private ITask taskRepo;

	@Test
	void saveTask() {
		Task testTask2 = new Task("task2", 1, 2, null, null, null, null);
		Assertions.assertNotNull(taskRepo.save(testTask2));
	}

	@Test
	void findAllTasks() {
		Task testTask = new Task("task", 1, 2, null, null, null, null);
		List<Task> resultTasks = new ArrayList<Task>();
		resultTasks.add(testTask);
		taskRepo.save(testTask);
		Assertions.assertEquals(resultTasks, taskRepo.findAll());
	}

}
