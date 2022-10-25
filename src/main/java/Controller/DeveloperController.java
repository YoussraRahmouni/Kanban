/**
 * 
 */
package Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Collection<Developer> getDevelopers() {
		return this.devService.findAllDevelopers();
	}


}
