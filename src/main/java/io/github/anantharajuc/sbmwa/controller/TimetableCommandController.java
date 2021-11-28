package io.github.anantharajuc.sbmwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.TimetableEntity;
import io.github.anantharajuc.sbmwa.service.TimetableServiceImpl;
import lombok.extern.log4j.Log4j2;


@RequestMapping("/smjh/timetable")
@Log4j2
@RestController
public class TimetableCommandController {
	
		
	@Autowired
	private TimetableServiceImpl timetableServiceImpl;
	
	
	@PostMapping("/insert")
	public TimetableEntity saveTimetableDetails(@RequestBody TimetableEntity timetableEntity)
	{
		log.info("-----> saveTimetableDetails controller");
		return timetableServiceImpl.saveTimetable(timetableEntity);
	}
	
	
	@PostMapping("/update/{id}")
	public TimetableEntity updateTimetableDetails(@PathVariable("id") Long id,@RequestBody TimetableEntity timetableEntity)
	{	
		log.info("-----> updateTimetable controller");
		return timetableServiceImpl.updateTimetable(id,timetableEntity);
	}
	
	
	
	@PostMapping("/delete/{id}")
	public void deleteTimetable(@PathVariable("id") Long id)
	{
		log.info("-----> deleteTimetable controller");
		timetableServiceImpl.deleteTimetable(id);
	}

	

}
