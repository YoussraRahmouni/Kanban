/**
 * 
 */
package org.tse.kanban.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class TaskType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String label;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
