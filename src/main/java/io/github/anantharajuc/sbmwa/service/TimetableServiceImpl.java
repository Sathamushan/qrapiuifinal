package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.TimetableEntity;
import io.github.anantharajuc.sbmwa.repository.TimetableEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TimetableServiceImpl implements ITimetableService
{
	@Autowired
	private TimetableEntityRepository timetableEntityRepository;

	@Override
	public TimetableEntity saveTimetable(TimetableEntity timetableEntity) 
	{
		log.info("-----> saveTimetable serviceImpl");
		return timetableEntityRepository.save(timetableEntity);
	}
	
	
	/**
	 * Delete data based upon id
	 * 
	 * @param id
	 */
	public void deleteTimetable(Long id) {
		timetableEntityRepository.deleteById(id);
	}

	@Override		
	public TimetableEntity updateTimetable(Long id, TimetableEntity timetableEntity) {
		log.info("-----> updateTimetable serviceImpl");
		log.info("-----> timetableEntity "+ timetableEntity.getTeachername());

		TimetableEntity timetableEntityData = timetableEntityRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TimetableEntity", "id", id));
		if(timetableEntityData!= null) {
			timetableEntityData.setSubject(timetableEntity.getSubject());
			timetableEntityData.setTeachername(timetableEntity.getTeachername());
			timetableEntityData.setPeriod(timetableEntity.getPeriod());
			timetableEntityData.setTt_day(timetableEntity.getTt_day());
			timetableEntityData.setClasse(timetableEntity.getClasse());
			timetableEntityData.setSection(timetableEntity.getSection());
			timetableEntityData.setTt_time(timetableEntity.getTt_time());
		}
		return timetableEntityRepository.save(timetableEntityData);
	}
	
}
