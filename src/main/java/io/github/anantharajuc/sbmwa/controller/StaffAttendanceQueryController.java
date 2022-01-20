package  io.github.anantharajuc.sbmwa.controller;

import java.io.File;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.StaffAttendanceEntity;
import io.github.anantharajuc.sbmwa.repository.StaffAttendanceEntityRepository;
import io.github.anantharajuc.sbmwa.service.StaffAttendanceServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/smjh/staffAttendance")
@Log4j2
@CrossOrigin
public class StaffAttendanceQueryController 
{
	@Autowired
	private StaffAttendanceEntityRepository staffattendanceEntityRepository;
	
	@Autowired
	private  StaffAttendanceServiceImpl staffattendanceServiceImpl;
	
	@GetMapping()	
	public List<StaffAttendanceEntity> findAllStaffAttendance()
	{
		return staffattendanceEntityRepository.findAll();
	}
	
	@PostMapping("/insert")
	public  StaffAttendanceEntity insertstaffAttandance(@RequestBody  StaffAttendanceEntity staffattendanceEntity)
	{
		log.info("-----> insertstaffAttandance controller");
		log.info("-----> attendanceEntity "+ staffattendanceEntity.getAttendancestatus());
	    playSound();
		return staffattendanceServiceImpl.insertstaffAttandanceDetails(staffattendanceEntity);
	}
	
	private void playSound() {
		//This gets the path to the project, but not into /src for eclipse
		String path = new File("E:\\QRAPINEW\\Spring-Boot-Minimal-Web-App-main\\src\\main\\resources\\path\\beep-01a.wav").toString();
		//Make a File object with a path to the audio file.
		File sound = new File(path);
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip c = AudioSystem.getClip();
			c.open(ais); //Clip opens AudioInputStream
			c.start(); //Start playing audio

			//sleep thread for length of the song
			Thread.sleep((int)(c.getMicrosecondLength() * 0.001));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@PostMapping("/updateById/{stdID}")
	public  StaffAttendanceEntity insertStaffAttandance(@PathVariable(value="stdID") Long studId)
	{
		log.info("-----> insertStaffAttandance controller");
		log.info("-----> updatestaffAttandanceById serviceImpl");
		playSound();
		return staffattendanceServiceImpl.updatestaffAttandanceById(studId);
	}


	@GetMapping("/{id}")	
	public  StaffAttendanceEntity findStaffAttendanceById(@PathVariable(value="id") Long id)
	{
		return staffattendanceEntityRepository.findById(id).get();
	}

}
