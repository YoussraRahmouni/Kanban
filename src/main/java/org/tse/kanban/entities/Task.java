/**
 * 
 */
package org.tse.kanban.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rahmouni Youssra
 *
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private int nbHoursForeCast;
	private int nbHoursReal;
	private Date created;
	
	// A task has one taskStatus
	@OneToOne
	private TaskStatus taskStatus;
	
	// A task has one taskType
	@OneToOne
	private TaskType taskType;
	
	// Many tasks to one changeLog 
	@ManyToOne
	private ChangeLog changeLog;
	

	public Task(String title, int nbHoursForeCast, int nbHoursReal, Date created, TaskStatus taskStatus,
			TaskType taskType, ChangeLog changeLog) {
		super();
		this.title = title;
		this.nbHoursForeCast = nbHoursForeCast;
		this.nbHoursReal = nbHoursReal;
		this.created = created;
		this.taskStatus = taskStatus;
		this.taskType = taskType;
		this.changeLog = changeLog;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getNbHoursForeCast() {
		return nbHoursForeCast;
	}


	public void setNbHoursForeCast(int nbHoursForeCast) {
		this.nbHoursForeCast = nbHoursForeCast;
	}


	public int getNbHoursReal() {
		return nbHoursReal;
	}


	public void setNbHoursReal(int nbHoursReal) {
		this.nbHoursReal = nbHoursReal;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public TaskStatus getTaskStatus() {
		return taskStatus;
	}


	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}


	public TaskType getTaskType() {
		return taskType;
	}


	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}


	public ChangeLog getChangeLog() {
		return changeLog;
	}


	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}
	
	
}
