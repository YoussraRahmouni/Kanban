/**
 * 
 */
package org.tse.kanban;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.tse.kanban.entities.Developer;
import org.tse.kanban.repository.IDeveloper;


/**
 * @author Rahmouni Youssra
 *
 */

@DataJpaTest
public class IDeveloperTest {
	
	@Autowired
	private IDeveloper developerRepo;
	
	@Test
	void findAllDevelopers() {
		Developer resultDeveloper = new Developer("youssra");
		
		List<Developer> devList = new ArrayList<Developer>(); 
		devList.add(resultDeveloper);
		
		Developer developer = developerRepo.save(resultDeveloper);
		
		Assertions.assertEquals(devList,developerRepo.findAll());	
	}

}
