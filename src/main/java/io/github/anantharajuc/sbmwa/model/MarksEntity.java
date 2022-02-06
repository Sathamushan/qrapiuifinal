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
	
	
	@Column(name="examtitle", nullable = true)
	String examtitle;
	
	@Column(name="tamil", nullable = true)
	String tamil;
	
	@Column(name="english", nullable = true)
	String english;
	
	@Column(name="maths", nullable = true)
	String maths;
	
	@Column(name="science", nullable = true)
	String science;
	
	@Column(name="socialscience", nullable = true)
	String socialscience;
	
	@Column(name="max_mark", nullable = true)
	String max_mark;
	
	@Column(name="total", nullable = true)
	String total;
	
	@Column(name="grade", nullable = true)
	String grade;
	
	@Column(name="result", nullable = true)
	String result;
	
	
	/*studentid varchar(45) 
	studentname varchar(45) 
	classe varchar(45) 
	section varchar(45) 
	examtitle varchar(45) 
	subject varchar(45) 
	tamil varchar(45) 
	english varchar(45) 
	maths varchar(45) 
	science varchar(45) 
	socialscience varchar(45) 
	total varchar(45) 
	max_mark varchar(45) 
	grade varchar(45) 
	result varchar(45) */

		
}

