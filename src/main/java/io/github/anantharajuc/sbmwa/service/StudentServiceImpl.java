package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public StudentEntity updateStudentDetails(Long id, StudentEntity studentEntity) {
		log.info("-----> updateStudentDetails serviceImpl");
		//StudentEntity studEntity = studentEntityRepository.findById(id)
			//	.orElseThrow(() -> new ResourceNotFoundException("StudentEntity", "id", id));
		//if(studEntity!= null) {
		//	studEntity.setAadharnumber(studentEntity.getAadharnumber());
			//if u want to do any values to set here

			/*studEntity.setStudentname(studentEntity.getStudentname());
		studEntity.setClasse(studentEntity.getClasse());
		studEntity.setSection(studentEntity.getSection());	
		studEntity.setClockontime(studentEntity.getClockontime());	
		studEntity.setClockofftime(studentEntity.getClockofftime());
		studEntity.setBreaktime(studentEntity.getBreaktime());
		studEntity.setAttendancestatus(studentEntity.getAttendancestatus());*/
		//}
		//return studentEntityRepository.save(studEntity);
		return studentEntityRepository.save(studentEntity);
	}

	
	public void deleteStudentDetail(Long id) {
		studentEntityRepository.deleteById(id);
	}
	
	

}
