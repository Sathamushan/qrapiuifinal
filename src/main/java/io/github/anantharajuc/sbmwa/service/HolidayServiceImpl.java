package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.HolidayEntity;
import io.github.anantharajuc.sbmwa.repository.HolidayEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class HolidayServiceImpl implements IHolidayServiceImpl {

	@Autowired
	private HolidayEntityRepository holidayEntityRepository;
	
	@Override
	public HolidayEntity saveHoliday(HolidayEntity holidayEntity) {
		log.info("-----> saveHoliday controller");
		return holidayEntityRepository.save(holidayEntity);
	}


	@Override
	public HolidayEntity updateHolidayData(Long id, HolidayEntity holidayEntity) {
		log.info("-----> updateHolidayData serviceImpl");
		log.info("-----> HolidayEntity "+ holidayEntity.getHolidayname());

		HolidayEntity holidaydata = holidayEntityRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("HolidayEntity", "id", id));
		if(holidaydata!= null) {
			holidaydata.setHolidayname(holidayEntity.getHolidayname());
			holidaydata.setHolidaytype(holidayEntity.getHolidaytype());
			holidaydata.setRemarks(holidayEntity.getRemarks());
			holidaydata.setWeekday(holidayEntity.getWeekday());
		}
		return holidayEntityRepository.save(holidaydata);
	}

	

	public void deleteHoliday(Long id) {
		log.info("-----> deleteHoliday controller");
		holidayEntityRepository.deleteById(id);
	}
	

}
