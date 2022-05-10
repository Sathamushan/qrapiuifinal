package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.StaffsEntity;
import io.github.anantharajuc.sbmwa.repository.StaffsEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StaffsServiceImpl implements IStaffsService{
	
	@Autowired
	private StaffsEntityRepository staffEntityRepository;

	@Override
	public StaffsEntity saveStaffDetails(StaffsEntity staffsEntity) {
		
		log.info("-----> saveStaffDetails serviceImpl");
		return staffEntityRepository.save(staffsEntity);
	}

	@Override
	public StaffsEntity updatestaffData(Long id, StaffsEntity staffsEntityUpdate) {
		log.info("-----> updateStaff serviceImpl");
		StaffsEntity staffsEntityResult = staffEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("StaffsEntity", "id", id));
		
		if(staffsEntityResult!= null) {
			staffsEntityResult.setParentname(staffsEntityUpdate.getParentname());
			staffsEntityResult.setName(staffsEntityUpdate.getName());
			staffsEntityResult.setClasse(staffsEntityUpdate.getClasse());
			staffsEntityResult.setAddress(staffsEntityUpdate.getAddress());
			staffsEntityResult.setSection(staffsEntityUpdate.getSection());	
			staffsEntityResult.setDepartment(staffsEntityUpdate.getDepartment());	
			staffsEntityResult.setDesignation(staffsEntityUpdate.getDesignation());	
			staffsEntityResult.setDob(staffsEntityUpdate.getDob());
			staffsEntityResult.setDateofjoining(staffsEntityUpdate.getDateofjoining());
			staffsEntityResult.setQualification(staffsEntityUpdate.getQualification());
			staffsEntityResult.setEmail(staffsEntityUpdate.getEmail());	
			staffsEntityResult.setExperience(staffsEntityUpdate.getExperience());	
			staffsEntityResult.setGender(staffsEntityUpdate.getGender());	
			staffsEntityResult.setMobilenumber(staffsEntityUpdate.getMobilenumber());	
			staffsEntityResult.setPriexperiencedetail(staffsEntityUpdate.getPriexperiencedetail());	
			staffsEntityResult.setPhotourl(staffsEntityUpdate.getPhotourl());
		}
		return staffEntityRepository.save(staffsEntityResult);
	}
	
	
	public void deleteStaff(Long id) {
		log.info("-----> deleteStaff serviceImpl");
		StaffsEntity staffsEntity = staffEntityRepository.getById(id);
		if(staffsEntity!=  null) {
			staffEntityRepository.deleteById(id);
		}
	}

}
