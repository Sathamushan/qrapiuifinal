package io.github.anantharajuc.sbmwa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="homework")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class HomeWorkEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;

	
	
	@Column(name="classe", nullable = true)
	String classe;
	
	
	@Column(name="section", nullable = true)
	String section;
	
	@Column(name="subject", nullable = true)
	String subject;
	
	@Column(name="classteachername", nullable = true)
	String classteachername;
	
	@Column(name="classteachercontact", nullable = true)
	String classteachercontact;
	
	@Column(name="assignmentname", nullable = true)
	String assignmentname;
	
	@Column(name="assignmenttype", nullable = true)
	String assignmenttype;
	
	
	@Column(name="assignmentdescriprion", nullable = true)
	String assignmentdescriprion;
	
	
	/*
	table: homeworkdetails
	columns:
	homeworkid int(11) ai pk 
	class varchar(45) 
	section varchar(45) 
	subject varchar(45) 
	classteachername varchar(45) 
	classteachercontact varchar(45) 
	assignmentname varchar(45) 
	assignmenttype varchar(45) 
	assignmentdescriprion varchar(45) 
	createdate varchar(45) 
	createdby varchar(45) 
	updatedate varchar(45) 
	updatedby varchar(45)*/
	
	
}


