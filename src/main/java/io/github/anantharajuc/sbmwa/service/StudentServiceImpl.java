package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;

import io.github.anantharajuc.sbmwa.model.StudentEntity;
import io.github.anantharajuc.sbmwa.repository.StudentEntityRepository;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentEntityRepository  studentEntityRepository;

	
	@Override
	public StudentEntity insertStudentDetails(StudentEntity studentEntity) {
		log.info("-----> saveStudentDetails serviceImpl");
		log.info("-----> studentEntity "+ studentEntity.getStudentnameinenglish());
		return studentEntityRepository.save(studentEntity);
	}

	@Override
	public StudentEntity updateStudentDetails(Long id, StudentEntity studentEntityupdate) {
		log.info("-----> updateStudentDetails serviceImpl");
		StudentEntity studEntityResult = studentEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("StudentEntity", "id", id));
		if(studEntityResult!= null) {
			studEntityResult.setAadharnumber(studentEntityupdate.getAadharnumber());
			studEntityResult.setStudentnameinenglish(studentEntityupdate.getStudentnameinenglish());
			studEntityResult.setStudentnameintamil(studentEntityupdate.getStudentnameintamil());
			studEntityResult.setDateofbirth(studentEntityupdate.getDateofbirth());
			studEntityResult.setPlaceofbirth(studentEntityupdate.getPlaceofbirth());
			studEntityResult.setGender(studentEntityupdate.getGender());
			studEntityResult.setReligion(studentEntityupdate.getReligion());
			studEntityResult.setRollno(studentEntityupdate.getRollno());
			studEntityResult.setCaste(studentEntityupdate.getCaste());
			
			
			//studEntityResult.setClasse(studentEntityupdate.getClasse());
			studEntityResult.setMothertongue(studentEntityupdate.getMothertongue());
			studEntityResult.setBloodgroup(studentEntityupdate.getBloodgroup());
			studEntityResult.setDisabilitygroupname(studentEntityupdate.getDisabilitygroupname());
			studEntityResult.setPhotourl(studentEntityupdate.getPhotourl());
			
			studEntityResult.setFathernameinenglish(studentEntityupdate.getFathernameinenglish());
			studEntityResult.setFathernameintamil(studentEntityupdate.getFathernameintamil());
			studEntityResult.setFathereducationlevel(studentEntityupdate.getFathereducationlevel());
			studEntityResult.setFathersoccupation(studentEntityupdate.getFathersoccupation());
			
			studEntityResult.setMothernameintamil(studentEntityupdate.getMothernameintamil());
			studEntityResult.setMothernameinenglish(studentEntityupdate.getMothernameinenglish());
			studEntityResult.setMothereducationlevel(studentEntityupdate.getMothereducationlevel());
			studEntityResult.setMothersoccupation(studentEntityupdate.getMothersoccupation());
			studEntityResult.setGuardiannameinenglish(studentEntityupdate.getGuardiannameinenglish());
			studEntityResult.setGuardiannameintamil(studentEntityupdate.getGuardiannameintamil());
			studEntityResult.setGuardianeducationlevel(studentEntityupdate.getGuardianeducationlevel());
			studEntityResult.setParentsannualincome(studentEntityupdate.getParentsannualincome());
			studEntityResult.setMobilenumber(studentEntityupdate.getMobilenumber());
			
			studEntityResult.setEmailid(studentEntityupdate.getEmailid());
			studEntityResult.setDoornoorbuildingname(studentEntityupdate.getDoornoorbuildingname());
			studEntityResult.setStreetnameareaname(studentEntityupdate.getStreetnameareaname());
			studEntityResult.setCitynamevillagename(studentEntityupdate.getCitynamevillagename());
			studEntityResult.setDistrict(studentEntityupdate.getDistrict());
			studEntityResult.setPincode(studentEntityupdate.getPincode());
			
			studEntityResult.setClassforwhich(studentEntityupdate.getClassforwhich());
			studEntityResult.setAdmissionissoughtfor(studentEntityupdate.getAdmissionissoughtfor());
			studEntityResult.setSection(studentEntityupdate.getSection());
			studEntityResult.setAdmissionnumber(studentEntityupdate.getAdmissionnumber());
			studEntityResult.setDateofjoining(studentEntityupdate.getDateofjoining());
			studEntityResult.setMediumofinstruction(studentEntityupdate.getMediumofinstruction());
		}
		return studentEntityRepository.save(studEntityResult);
	}

	
	public void deleteStudentDetail(Long id) {
		log.info("-----> deleteStudent serviceImpl");
		StudentEntity studentEntity = studentEntityRepository.getById(id);
		if(studentEntity!=  null) {
			studentEntityRepository.deleteById(id);
		}
	}
	
	

}
