/**
 * 
 */
package org.tse.kanban.entities;

import java.util.Date;

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
public class ChangeLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date occured;

}
