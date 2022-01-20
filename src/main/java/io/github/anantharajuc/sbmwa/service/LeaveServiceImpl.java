package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.LeaveEntity;
import io.github.anantharajuc.sbmwa.repository.LeaveEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LeaveServiceImpl implements ILeaveService
{
	@Autowired
	private LeaveEntityRepository leaveEntityRepository;

	@Override
	public LeaveEntity saveLeave(LeaveEntity leaveEntity) 
	{
		log.info("-----> saveleaveEntity serviceImpl");
		log.info("-----> leaveEntity "+ leaveEntity.getStudentid());
		return leaveEntityRepository.save(leaveEntity);
	}
	
	
	
	public void deleteleave(Long id) {
		leaveEntityRepository.deleteById(id);
	}

	@Override
	public LeaveEntity updateLeave(Long id, LeaveEntity leaveEntityUpdated) {
		log.info("-----> updateLeave serviceImpl");

		LeaveEntity leaveData = leaveEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LeaveEntity", "id", id));
		if(leaveData!= null) {
			leaveData.setStudentname(leaveEntityUpdated.getStudentname());
			leaveData.setClasse(leaveEntityUpdated.getClasse());
			leaveData.setLeavereason(leaveEntityUpdated.getLeavereason());
			leaveData.setSection(leaveEntityUpdated.getSection());	
		}
		return leaveEntityRepository.save(leaveData);
	}
	
}
