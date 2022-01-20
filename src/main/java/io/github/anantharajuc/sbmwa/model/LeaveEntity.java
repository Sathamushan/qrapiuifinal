package io.github.anantharajuc.sbmwa.model;

import java.util.Date;

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
@Table(name="leavedetails")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class LeaveEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="studentid", nullable = true)
	String studentid; 
	
	@Column(name="studentname", nullable = true)
	String studentname;
	
	@Column(name="classe", nullable = true)
	String  classe;
	
	@Column(name="section", nullable = true)
	String  section;
	
	@Column(name="leavefromdate", nullable = true)
	Date  leavefromdate;
	
	@Column(name="leavetodate", nullable = true)
	Date  leavetodate;
	
	@Column(name="approvalstatus", nullable = true)
	String  approvalstatus;
	
	
	@Column(name="leavereason", nullable = true)
	String  leavereason;
	

	@Column(name="uploaddocument", nullable = true)
	String  uploaddocument;
	
	

	
}
/*
table: leavedetails
columns:
leaveid int(11) ai pk 

studentname varchar(45) 
class varchar(45) 
section varchar(45) 
leavefromdate date 
leavetodate date 
approvalstatus varchar(45) 
leavereason varchar(45) 
uploaddocument varchar(45) 
createdate varchar(45) 
createdby varchar(45) 
updatedate varchar(45) 
updatedby varchar(45)*/