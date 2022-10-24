/**
 * 
 */
package org.tse.kanban.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.tse.kanban.entities.Developer;
import org.tse.kanban.repository.IDeveloper;

import lombok.AllArgsConstructor;

/**
 * @author Rahmouni Youssra
 *
 */
@Component
@AllArgsConstructor
public class InitialData implements CommandLineRunner {
	
	@Autowired
	private IDeveloper developerRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Developer developer = developerRepo.save(new Developer("youssra"));
		System.out.println(developer.toString());
		
	}

}
