/**
 * 
 */
package org.tse.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.kanban.entities.ChangeLog;

/**
 * @author Rahmouni Youssra
 *
 */
public interface IChangeLog extends JpaRepository<ChangeLog, Long> {

}
