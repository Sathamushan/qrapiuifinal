package io.github.anantharajuc.sbmwa.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="staffattendance")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class StaffAttendanceEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;


	@Column(name="staffid", nullable = true)
	Long  staffid;
	
	@Column(name="name", nullable = true)
	String name;
	
	@Column(name="designation", nullable = true)
	String designation;
	
	@Column(name="department", nullable = true)
	String department;
	
	@Column(name="clockontime", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date clockontime;
	
	
	@Column(name="clockofftime", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date clockofftime; 
	
	
	@Column(name="breaktime", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date breaktime; 
	
	@Column(name="attendancestatus", nullable = true)
	String attendancestatus;
	
	
	@Column(name="durationminute", nullable = true)
	Long durationminute;
	
	@Column(name="durationhours", nullable = true)
	Long durationhours;
	
	
	@Column(name="schoolcode", nullable = true)
	String schoolcode;
	
	@Column(name="currentdate", nullable = true)
	Date currentdate; 
	
}




