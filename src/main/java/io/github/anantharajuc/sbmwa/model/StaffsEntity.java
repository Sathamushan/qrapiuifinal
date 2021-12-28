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
@Table(name="staffs")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class StaffsEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;
		
	@Column(name="name", nullable = true)
	String name;
	
	@Column(name="parentname", nullable = true)
	String parentname;
	
	
	@Column(name="classe", nullable = true)
	String classe;
	
	@Column(name="section", nullable = true)
	String section;
		
	@Column(name="email", nullable = true)
	String email;	
	
	
	@Column(name="mobilenumber", nullable = true)
	String mobilenumber;	
	
	@Column(name="gender", nullable = true)
	String gender;	
	
	@Column(name="designation", nullable = true)
	String designation;	
	
	@Column(name="department", nullable = true)
	String department;	
	
	@Column(name="dob", nullable = true)
	String dob;	
	
	@Column(name="qualification", nullable = true)
	String qualification;	
	
	@Column(name="experience", nullable = true)
	String experience;	
	
	@Column(name="priexperiencedetail", nullable = true)
	String priexperiencedetail;	
	
	@Column(name="address", nullable = true)
	String address;	
	
	@Column(name="dateofjoining", nullable = true)
	String dateofjoining;
	
	@Column(name="photourl", nullable = true)
	String photourl;
	
	
	
}




