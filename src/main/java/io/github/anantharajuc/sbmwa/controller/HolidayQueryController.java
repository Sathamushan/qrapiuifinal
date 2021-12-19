package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.HolidayEntity;
import io.github.anantharajuc.sbmwa.repository.HolidayEntityRepository;

@RestController
@CrossOrigin
@RequestMapping("/smjh/holiday")
public class HolidayQueryController 
{
	@Autowired
	private HolidayEntityRepository holidayEntityRepository;
	
	@GetMapping()	
	public List<HolidayEntity> findAllHoliday()
	{
		return holidayEntityRepository.findAll();
	}
	
	@GetMapping("/{id}")	
	public HolidayEntity findHolidayById(@PathVariable Long id)
	{
		return holidayEntityRepository.findById(id).get(); 
	}

}
