/**
 * 
 */
package org.tse.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kanban.entities.Task;

/**
 * @author Rahmouni Youssra
 *
 */
public interface ITask extends JpaRepository<Task, Long> {

}
