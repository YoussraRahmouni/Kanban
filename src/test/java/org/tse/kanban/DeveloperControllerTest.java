/**
 * 
 */
package org.tse.kanban;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.tse.kanban.controller.DeveloperController;
import org.tse.kanban.entities.Developer;
import org.tse.kanban.services.DeveloperService;

/**
 * @author Rahmouni Youssra
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = DeveloperController.class)
@WithMockUser
public class DeveloperControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DeveloperService devService;

	List<Developer> mockDeveloper = new ArrayList<Developer>();
	

	@Test
	public void getDevelopers() throws Exception {
		
		mockDeveloper.add(new Developer("youssra"));

		Mockito.when(devService.findAllDevelopers()).thenReturn(mockDeveloper);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/developers").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"id\":0,\"firstName\":\"youssra\",\"lastName\":null,\"password\":null,\"email\":null,\"startContract\":null,\"taskList\":null}]";
		
		assertEquals(expected, result.getResponse()
				.getContentAsString());
	}


}
