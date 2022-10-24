/**
 * 
 */
package org.tse.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kanban.entities.Developer;

/**
 * @author Rahmouni Youssra
 *
 */
public interface IDeveloper extends JpaRepository<Developer, Long> {

}
