package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.HomeWorkEntity;
import io.github.anantharajuc.sbmwa.repository.HomeWorkEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class HomeWorkServiceImpl implements IHomeWorkServiceImpl {

	@Autowired
	private HomeWorkEntityRepository homeWorkEntityRepository;
	
	@Override
	public HomeWorkEntity saveHomework(HomeWorkEntity homeWorkEntity) {
		log.info("-----> saveHomework controller");
		return homeWorkEntityRepository.save(homeWorkEntity);
	}


	@Override
	public HomeWorkEntity updateHomework(Long id, HomeWorkEntity homeWorkEntity) {
		log.info("-----> updateHomework serviceImpl");
		log.info("-----> HomeWorkEntity "+ homeWorkEntity.getAssignmentname());

		HomeWorkEntity homeWorkData = homeWorkEntityRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("HomeWorkEntity", "id", id));
		if(homeWorkData!= null) {
			homeWorkData.setAssignmentdescriprion(homeWorkEntity.getAssignmentdescriprion());
			homeWorkData.setAssignmentname(homeWorkEntity.getAssignmentname());
			homeWorkData.setAssignmenttype(homeWorkEntity.getAssignmenttype());
			homeWorkData.setClasse(homeWorkEntity.getClasse());
			homeWorkData.setClassteachercontact(homeWorkEntity.getClassteachercontact());
			homeWorkData.setClassteachername(homeWorkEntity.getClassteachername());
			homeWorkData.setSection(homeWorkEntity.getSection());
			homeWorkData.setSubject(homeWorkEntity.getSubject());
		}
		return homeWorkEntityRepository.save(homeWorkData);
	}

	

	public void deleteHomeWork(Long id) {
		log.info("-----> deleteHoliday controller");
		homeWorkEntityRepository.deleteById(id);
	}



}
