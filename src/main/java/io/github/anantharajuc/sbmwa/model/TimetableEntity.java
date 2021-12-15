package  io.github.anantharajuc.sbmwa.model;

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
@Table(name="timetable")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class TimetableEntity extends AuditEntity
{
	
	private static final long serialVersionUID = 1L;

	@Column(name="classe", nullable = true)
	String classe;
	
	@Column(name="section", nullable = true)
	String section;
	
	@Column(name="subject", nullable = true)
	String subject;
	
	@Column(name="teachername", nullable = true)
	String teachername;
	
	@Column(name="period", nullable = true)
	String period;
	
	
	
	@Column(name="tt_day", nullable = true)
	String tt_day;
	
	@Column(name="tt_time", nullable = true)
	String tt_time;
	
}




