package io.github.anantharajuc.sbmwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.MarksEntity;
import io.github.anantharajuc.sbmwa.service.MarkServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin
@RequestMapping("/smjh/mark")
@Log4j2
public class MarkCommandController {

	
	@Autowired
	private MarkServiceImpl markServiceImpl;
	
	@PostMapping("/insert")
	public MarksEntity saveMarkData(@RequestBody MarksEntity marksEntity)
	{
		log.info("-----> saveMarkData controller");
		return markServiceImpl.saveMarksDetails(marksEntity);
	}
	
	
	@PostMapping("/update/{id}")
	public MarksEntity updateHomeWorkData(@PathVariable("id") Long id,@RequestBody MarksEntity marksEntity)
	{		
		return markServiceImpl.updateMarksData(id,marksEntity);
	}
	
	@PostMapping("/delete/{id}")
	public void deleteMark(@PathVariable("id") Long id)
	{
		markServiceImpl.deleteMarks(id);
	}
}