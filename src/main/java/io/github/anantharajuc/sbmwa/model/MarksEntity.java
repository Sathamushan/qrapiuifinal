package io.github.anantharajuc.sbmwa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="marks")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class MarksEntity extends AuditEntity
{
		
	private static final long serialVersionUID = 1L;

	@Column(name="studentname", nullable = true)
	String studentname;
	
	@Column(name="classe", nullable = true)
	String classe;
	
	@Column(name="studentid", nullable = true)
	String studentid;
	
	@Column(name="section", nullable = true)
	String section;
	
	@Column(name="subject", nullable = true)
	String subject;
	
	
	@Column(name="mark", nullable = true)
	String mark;
	
	@Column(name="max_mark", nullable = true)
	String max_mark;
	
	@Column(name="avg", nullable = true)
	String avg;
	
	@Column(name="result", nullable = true)
	String result;
	
	
	
	
	/*`studentid` varchar(45) default null,
	  `studentname` varchar(45) default null,
	  `classe` varchar(45) default null,
	  `section` varchar(45) default null,
	  `subject` varchar(45) default null,
	  `mark` varchar(45) default null,
	  `max_mark` varchar(45) default null,
	  `result` varchar(45) default null,
	  `avg` varchar(45) default null,*/
	
	
	
}

