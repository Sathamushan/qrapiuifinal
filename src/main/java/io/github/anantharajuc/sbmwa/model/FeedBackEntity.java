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
@Table(name="feedback")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class FeedBackEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;

	@Column(name="studentname", nullable = true)
	String studentname;
	
	@Column(name="parentname", nullable = true)
	String parentname;
	
	
	@Column(name="classe", nullable = true)
	String classe;
	
	@Column(name="section", nullable = true)
	String section;
	
	@Column(name="feedbackdescription", nullable = true)
	String feedbackdescription;
	
	
	@Column(name="studentid", nullable = true)
	String studentid; 
	
	
	@Column(name="fbstatus", nullable = true)
	String fbstatus; 
	
	@Column(name="fbresponce", nullable = true)
	String fbresponce; 
	
	

	/*@Column(name="feedbackid", nullable = true)
	int  feedbackid;*/
	
	
/*table: feedback
columns:
feedbackid int(11) ai pk 
parentname varchar(45) 
studentid varchar(45) 
studentname varchar(45) 
class varchar(45) 
section varchar(45) 
feedbackdescription varchar(45) 
createdate varchar(45) 
createdby varchar(45) 
updatedate varchar(45) 
updatedby varchar(45)*/
	
}




