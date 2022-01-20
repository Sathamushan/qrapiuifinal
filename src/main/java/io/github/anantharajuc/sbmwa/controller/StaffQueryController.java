package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.StaffsEntity;
import io.github.anantharajuc.sbmwa.repository.StaffsEntityRepository;

@RestController
@CrossOrigin
@RequestMapping("/smjh/staff")
public class StaffQueryController 
{
	@Autowired
	private StaffsEntityRepository staffsEntityRepository;
	
	@GetMapping()	
	public List<StaffsEntity> findAllStudents()
	{
		return staffsEntityRepository.findAll();
	}
	
	@GetMapping("/{id}")	
	public StaffsEntity findStaffById(@PathVariable Long id)
	{
		return staffsEntityRepository.findById(id).get(); 
	}

	@GetMapping("/getClassStaffByStud/{classe}/{section}")
	public  StaffsEntity getClassByStudId(@PathVariable("classe") String classe,@PathVariable("section") String section) {	
		return staffsEntityRepository.getClassByStudId(classe,section);
	}
}
