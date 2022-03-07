package io.github.anantharajuc.sbmwa.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class StudentEntityBatchDto {

    Long id;
	String studentnameinenglish;
	String studentnameintamil;
	String aadharnumber;
	String dateofbirth;
	String placeofbirth;
	String gender;
	String religion;
	String mothertongue;
	String bloodgroup;
	String disabilitygroupname;
	String photourl;
	String fathernameinenglish;
	String fathernameintamil;
	String fathereducationlevel;
	String fathersoccupation;
	String mothernameinenglish;
	String mothernameintamil;
	String mothereducationlevel;
	String mothersoccupation;
	String guardiannameinenglish;
	String guardiannameintamil;
	String guardianeducationlevel;
	String parentsannualincome;
	String mobilenumber;
	String emailid;
	String doornoorbuildingname;
	String streetnameareaname;
	String citynamevillagename;
	String district;
	String pincode;
	String classforwhich;
	String admissionissoughtfor;
	String admissionnumber;
	String dateofjoining;
	String mediumofinstruction;
	String section;
	String caste;
	String rollno;
}
