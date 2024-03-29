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



import io.github.anantharajuc.sbmwa.model.StudentAttendanceEntity;
import io.github.anantharajuc.sbmwa.repository.StudentAttendanceEntityRepository;
import io.github.anantharajuc.sbmwa.service.StudentAttendanceServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/smjh/studAttendance")
@Log4j2
@CrossOrigin
public class StudentAttendanceQueryController 
{
	@Autowired
	private StudentAttendanceEntityRepository attendanceEntityRepository;
	
	@Autowired
	private StudentAttendanceServiceImpl attendanceServiceImpl;
	
	@GetMapping()	
	public List<StudentAttendanceEntity> findAllAttendance()
	{
		return attendanceEntityRepository.findAll();
	}
	
	@PostMapping("/insert")
	public StudentAttendanceEntity insertAttandance(@RequestBody StudentAttendanceEntity attendanceEntity)
	{
		log.info("-----> saveAttendanceEntity controller");
		log.info("-----> attendanceEntity "+ attendanceEntity.getStudentname());
		//File sound = new File("/resources/path/beep-01a.wav");
	    playSound();
		return attendanceServiceImpl.insertAttandanceDetails(attendanceEntity);
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
	public StudentAttendanceEntity insertAttandance(@PathVariable(value="stdID") Long studId)
	{
		log.info("-----> saveAttendanceEntity controller");
		log.info("-----> updateAttandanceDetails serviceImpl");
		playSound();
		return attendanceServiceImpl.updateAttandanceById(studId);
	}


	@GetMapping("/{id}")	
	public StudentAttendanceEntity findAttendanceById(@PathVariable(value="id") Long id)
	{
		return attendanceEntityRepository.findById(id).get();
	}

}
