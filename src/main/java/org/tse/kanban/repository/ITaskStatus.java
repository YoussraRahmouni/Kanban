/**
 * 
 */
package org.tse.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kanban.entities.TaskStatus;

/**
 * @author Rahmouni Youssra
 *
 */
public interface ITaskStatus extends JpaRepository<TaskStatus, Long> {

}
