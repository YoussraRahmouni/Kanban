package org.tse.kanban;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.tse.kanban.controller.TaskController;
import org.tse.kanban.entities.Task;
import org.tse.kanban.services.TaskService;
/**
 * @author Rahmouni Youssra
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TaskController.class)
@WithMockUser
public class TaskControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;
	
	String taskContent = "{\"title\":\"Add button\",\"nbHoursForeCast\":1,\"nbHoursReal\":2,\"created\":null"
			+ ",\"taskStatus\":null,\"taskType\":null,\"changeLog\":null"
			+ "}";
	@Test
	public void createTask() throws Exception {
		Task mockTask = new Task("Add button",1,2,null,null,null,null);
		//System.out.println(mockTask);
		Mockito.when(taskService.createTask(
				Mockito.any(Task.class))).thenReturn(mockTask);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/tasks")
				.accept(MediaType.APPLICATION_JSON).content(taskContent)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
}
