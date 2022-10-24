/**
 * 
 */
package org.tse.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kanban.entities.TaskType;

/**
 * @author Rahmouni Youssra
 *
 */
public interface ITaskType extends JpaRepository<TaskType, Long> {

}
