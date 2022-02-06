package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.MarksEntity;
import io.github.anantharajuc.sbmwa.repository.MarksEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MarkServiceImpl implements IMarkService{
	
	@Autowired
	private MarksEntityRepository marksEntityRepository;

	public MarksEntity saveMarksDetails(MarksEntity marksEntity) {
		
		log.info("-----> saveMarksDetails serviceImpl");
		return marksEntityRepository.save(marksEntity);
	}

	@Override
	public MarksEntity updateMarksData(Long id, MarksEntity marksEntityUpdate) {
		log.info("-----> updateMarksData serviceImpl");
		MarksEntity marksEntityResult = marksEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("MarksEntity", "id", id));
		
		if(marksEntityResult!= null) {
			marksEntityResult.setStudentid(marksEntityUpdate.getStudentid());
			marksEntityResult.setStudentname(marksEntityUpdate.getStudentname());
			marksEntityResult.setClasse(marksEntityUpdate.getClasse());
			marksEntityResult.setSection(marksEntityUpdate.getSection());	
			marksEntityResult.setSubject(marksEntityUpdate.getSubject());
			marksEntityResult.setTamil(marksEntityUpdate.getTamil());
			marksEntityResult.setEnglish(marksEntityUpdate.getEnglish());
			marksEntityResult.setMaths(marksEntityUpdate.getMaths());
			marksEntityResult.setScience(marksEntityUpdate.getScience());
			marksEntityResult.setSocialscience(marksEntityUpdate.getSocialscience());
			marksEntityResult.setMax_mark(marksEntityUpdate.getMax_mark());
			marksEntityResult.setTotal(marksEntityUpdate.getTotal());
			marksEntityResult.setResult(marksEntityUpdate.getResult());
			marksEntityResult.setGrade(marksEntityUpdate.getGrade());
			marksEntityResult.setExamtitle(marksEntityUpdate.getExamtitle());
		}
		return marksEntityRepository.save(marksEntityResult);
	}
	
	
	public void deleteMarks(Long id) {
		log.info("-----> deleteMarks serviceImpl");
		MarksEntity marksEntity = marksEntityRepository.getById(id);
		if(marksEntity!=  null) {
			marksEntityRepository.deleteById(id);
		}
	}


	

}
