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
@Table(name="holiday")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class HolidayEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;

	
	@Column(name="startdate", nullable = true)
	String startdate;
	
	@Column(name="enddate", nullable = true)
	String enddate;
		
		
	@Column(name="holidayname", nullable = true)
	String holidayname;
	
	@Column(name="remarks", nullable = true)
	String remarks;
	
	@Column(name="holidaytype", nullable = true)
	String holidaytype;
	
}


