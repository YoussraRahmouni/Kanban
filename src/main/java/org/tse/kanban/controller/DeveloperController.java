/**
 * 
 */
package org.tse.kanban.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tse.kanban.entities.Developer;
import org.tse.kanban.services.DeveloperService;

/**
 * @author Rahmouni Youssra
 *
 */
@RestController
public class DeveloperController {
	
	@Autowired
	private DeveloperService devService;
	
	@GetMapping("/developers")
	public List<Developer> getDevelopers() {
		return this.devService.findAllDevelopers();
	}
	
	@PostMapping("/developer")
	public Developer createDeveloper(@RequestBody Developer developer) {
		return this.devService.createDeveloper(developer);
	}
	
	@GetMapping("/developers/{id}")
	public Developer getDeveloper(@RequestBody long id) {
		return this.devService.findDeveloperById(id);
	}

}
