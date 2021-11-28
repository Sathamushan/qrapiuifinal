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
@Table(name="marks")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class MarksEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;

	
	@Column(name="studentname", nullable = false)
	String studentname;
	
	@Column(name="classe", nullable = false)
	String classe;
	
	
	@Column(name="section", nullable = false)
	String section;
	
	@Column(name="sub1", nullable = false)
	String sub1;
	
	@Column(name="sub2", nullable = false)
	String sub2;
	
	@Column(name="sub3", nullable = false)
	String sub3;
	@Column(name="sub4", nullable = false)
	String sub4;
	@Column(name="sub5", nullable = false)
	String sub5;
	@Column(name="sub6", nullable = false)
	String sub6;
	@Column(name="sub7", nullable = false)
	String sub7;
	@Column(name="sub8", nullable = false)
	String sub8;
	@Column(name="sub9", nullable = false)
	String sub9;
	@Column(name="sub10", nullable = false)
	String sub10;
	@Column(name="total", nullable = false)
	String total;
	
	
}

