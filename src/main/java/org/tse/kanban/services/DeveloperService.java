/**
 * 
 */
package org.tse.kanban.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tse.kanban.entities.Developer;
import org.tse.kanban.entities.Task;
import org.tse.kanban.repository.IDeveloper;

/**
 * @author Rahmouni Youssra
 *
 */
@Service
public class DeveloperService {
	@Autowired
	private IDeveloper developerRepo;
	
	public List<Developer> findAllDevelopers(){
		return developerRepo.findAll();
	}
	
	public Developer findDeveloperById(long id) {
		return developerRepo.findById(id).get();
	}
	
	public Developer createDeveloper(Developer developer) {
		return developerRepo.save(developer);
	}
	
	public void updateDeveloperFirstName(long id, String firstName) {
		Optional<Developer> developer = developerRepo.findById(id);
		developer.get().setFirstName(firstName);
		developerRepo.save(developer.get());
	}
	
	public void deleteDeveloper(long id) {
		Optional<Developer> developer = developerRepo.findById(id);
		developerRepo.delete(developer.get());
	}
	public List<Task> findTasksByDeveloper(long id){	
		return developerRepo.findById(id).get().getTaskList();
	}
	
}
