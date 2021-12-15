package io.github.anantharajuc.sbmwa.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="studentdetail")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class StudentEntity extends AuditEntity
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="studentnameinenglish", nullable = true)
	String studentnameinenglish;
	
	@Column(name="studentnameintamil", nullable = true)
	String studentnameintamil;
	
	@Column(name="aadharnumber", nullable = true)
	String aadharnumber;
	
	
	@Column(name="dateofbirth", nullable = true)
	String dateofbirth;
	

	@Column(name="placeofbirth", nullable = true)
	String placeofbirth;
	
	@Column(name="gender", nullable = true)
	String gender;
	
	@Column(name="religion", nullable = true)
	String religion;
	
	/*@Column(name="classe", nullable = true)
	String classe;*/
	
	@Column(name="mothertongue", nullable = true)
	String mothertongue;
	
	
	@Column(name="bloodgroup", nullable = true)
	String bloodgroup;
	
	@Column(name="disabilitygroupname", nullable = true)
	String disabilitygroupname;

	@Column(name="photourl", nullable = true)
	String photourl;
	
	@Column(name="fathernameinenglish", nullable = true)
	String fathernameinenglish;
	
	@Column(name="fathernameintamil", nullable = true)
	String fathernameintamil;
	
	@Column(name="fathereducationlevel", nullable = true)
	String fathereducationlevel;
	
	
	@Column(name="fathersoccupation", nullable = true)
	String fathersoccupation;

	
	
	@Column(name="mothernameinenglish", nullable = true)
	String mothernameinenglish;
	
	@Column(name="mothernameintamil", nullable = true)
	String mothernameintamil;

	@Column(name="mothereducationlevel", nullable = true)
	String mothereducationlevel;

	@Column(name="mothersoccupation", nullable = true)
	String mothersoccupation;

	@Column(name="guardiannameinenglish", nullable = true)
	String guardiannameinenglish;

	@Column(name="guardiannameintamil", nullable = true)
	String guardiannameintamil;

	@Column(name="guardianeducationlevel", nullable = true)
	String guardianeducationlevel;
	
	@Column(name="parentsannualincome", nullable = true)
	String parentsannualincome;

	@Column(name="mobilenumber", nullable = true)
	String mobilenumber;
	
	@Email
	@Column(name="emailid", nullable = true)
	String emailid;
	
	@Column(name="doornoorbuildingname", nullable = true)
	String doornoorbuildingname;
	
	@Column(name="streetnameareaname", nullable = true)
	String streetnameareaname;
	
	@Column(name="citynamevillagename", nullable = true)
	String citynamevillagename;
	
	@Column(name="district", nullable = true)
	String district;
	
	@Column(name="pincode", nullable = true)
	String pincode;

	@Column(name="classforwhich", nullable = true)
	String classforwhich;
	
	@Column(name="admissionissoughtfor", nullable = true)
	String admissionissoughtfor;
	
	@Column(name="admissionnumber", nullable = true)
	String admissionnumber;
	
	@Column(name="dateofjoining", nullable = true)
	String dateofjoining;
	
	@Column(name="mediumofinstruction", nullable = true)
	String mediumofinstruction;
	
	@Column(name="section", nullable = true)
	String section;
	
	
	@Column(name="caste", nullable = true)
	String caste;
	
	@Column(name="rollno", nullable = true)
	String rollno;
	
	

	/*@Column(name="name", nullable = true)
	String name;
	
	@Email
	@Column(name="email", nullable = true, unique=true)
	String email;
	
	@Column(name="mobile_number", nullable = true)
	String mobileNumber;*/	
	
	/*@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="address_id")
	Address address;*/
	
	
	
	/*1.Student Information Table:;
	StudentId
	StudentNameinEnglish(*)
	StudentNameinTamil
	AADHAR Number
	Date of Birth - பிறந்த தேதி *
	PlaceOfBirth
	Gender *
	Religion *
	Class *
	 -BC ,MBC,SC,ST
	Mother tongue *
	Blood Group
	Disability Group Name
	Photourl

	2.Family Details
	Father Name in English
	Father Name in Tamil
	Father Education Level
	Father's Occupation
	Mother Name in English
	Mother Name in Tamil
	Mother Education Level
	Mother's Occupation
	Guardian Name in English
	Guardian Name in Tamil
	Guardian Education Level
	Parents Annual Income

	3.Communication Details
	Mobile Number*
	Email ID
	Door no./Building Name *
	Street Name / Area Name *
	City name / Village name *
	District *
	Pincode *


	4. Academic info

	Class for which 
	Admission is sought for *
	Section *
	Admission Number *
	Date of Joining - சேர்க்கை தேதி *
	Medium of Instruction *
	Created by
	Update Date
	Create User
	Updated by*/
}
