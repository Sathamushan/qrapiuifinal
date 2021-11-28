package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.TimetableEntity;
import io.github.anantharajuc.sbmwa.repository.TimetableEntityRepository;
import lombok.extern.log4j.Log4j2;


@RequestMapping("/smjh/timetable")
@Log4j2
@RestController
public class TimetableQueryController 
{
	@Autowired
	private TimetableEntityRepository timetableEntityRepository;
	
	
	
	@GetMapping()	
	public List<TimetableEntity> findTimetable()
	{
		return timetableEntityRepository.findAll();
	}
	
	
	@GetMapping("/{id}")	
	public TimetableEntity findTimetableById(@PathVariable(value="id") Long id)
	{
		log.info("-----> QueryController find by Id");
		return timetableEntityRepository.findById(id).get();  
	}

}
