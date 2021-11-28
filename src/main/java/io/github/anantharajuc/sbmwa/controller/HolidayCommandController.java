package io.github.anantharajuc.sbmwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.HolidayEntity;
import io.github.anantharajuc.sbmwa.service.HolidayServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/smjh/holiday")
@Log4j2
public class HolidayCommandController {


	@Autowired
	private  HolidayServiceImpl holidayServiceImpl;
	
	@PostMapping("/insert")
	public HolidayEntity saveHoliday(@RequestBody HolidayEntity holidayEntity)
	{
		log.info("-----> saveHoliday controller");
		log.info("-----> holidayEntity "+ holidayEntity.getHolidayname());
		
		return holidayServiceImpl.saveHoliday(holidayEntity);
	}
	
	
	@PostMapping("/update/{id}")
	public HolidayEntity  updateHoliday(@PathVariable("id") Long id,@RequestBody HolidayEntity holidayEntity)
	{	
		log.info("-----> updateHoliday controller");
		return holidayServiceImpl.updateHolidayData(id,holidayEntity);
	}
	

	@PostMapping("/delete/{id}")
	public void deleteHoliday(@PathVariable("id") Long id)
	{
		log.info("-----> deleteHoliday controller");
		holidayServiceImpl.deleteHoliday(id);
	}
	
	
	

}
