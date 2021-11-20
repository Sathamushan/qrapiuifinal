package io.github.anantharajuc.sbmwa.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.AttendanceEntity;
import io.github.anantharajuc.sbmwa.repository.AttendanceEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AttendanceServiceImpl	 implements IAttendanceService
{
	@Autowired
	private AttendanceEntityRepository attendanceEntityRepository;

	@Override
	public AttendanceEntity insertAttandanceDetails(AttendanceEntity attendanceEntity) 
	{
		log.info("-----> saveAttendanceDetails serviceImpl");
		  
		log.info("-----> attendanceEntity "+ attendanceEntity.getAttendancestatus());
		AttendanceEntity attEntity = new AttendanceEntity ();
		if(attendanceEntity != null) {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
			attEntity.setStudentid(attendanceEntity.getStudentid());
			attEntity.setStudentname(attendanceEntity.getStudentname());
			attEntity.setClasse(attendanceEntity.getClasse());
			attEntity.setSection(attendanceEntity.getSection());	
			attEntity.setClockontime(new Date());	
			attEntity.setClockofftime(null);
			attEntity.setBreaktime(attendanceEntity.getBreaktime());
			attEntity.setSchoolcode(attendanceEntity.getSchoolcode());
			attEntity.setDurationhours(attendanceEntity.getDurationhours());
			attEntity.setDurationminute(attendanceEntity.getDurationminute());
			attEntity.setAttendancestatus(attendanceEntity.getAttendancestatus());
			attEntity.setCurrentdate(date);
		}
		return attendanceEntityRepository.save(attEntity);
	}

	@Override
	public AttendanceEntity updateAttandanceDetails(Long id, AttendanceEntity attenEntityUpdated) {
		log.info("-----> updateAttandanceDetails serviceImpl");
		AttendanceEntity attEntity = attendanceEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AttendanceEntity", "id", id));
		if(attEntity!= null) {
			attEntity.setStudentid(attenEntityUpdated.getStudentid());
			attEntity.setStudentname(attenEntityUpdated.getStudentname());
			attEntity.setClasse(attenEntityUpdated.getClasse());
			attEntity.setSection(attenEntityUpdated.getSection());	
			attEntity.setClockontime(attenEntityUpdated.getClockontime());	
			attEntity.setClockofftime(attenEntityUpdated.getClockofftime());
			attEntity.setBreaktime(attenEntityUpdated.getBreaktime());
			attEntity.setAttendancestatus(attenEntityUpdated.getAttendancestatus());
		}
		return attendanceEntityRepository.save(attEntity);
	}

	public void deleteAttandance(Long id) {

		log.info("-----> deleteAttandance serviceImpl");
		attendanceEntityRepository.deleteById(id);
		AttendanceEntity attendanceEntity = attendanceEntityRepository.getById(id);
		if(attendanceEntity!=  null) {
			attendanceEntityRepository.deleteById(id);
		}
	}
	
	
	@Override
	public AttendanceEntity updateAttandanceById(Long studId) {
		log.info("-----> updateAttandanceById serviceImpl");
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		System.out.println(date);
		AttendanceEntity attEntity = attendanceEntityRepository.getStudentById(studId, date);
				//.orElseThrow(() -> new ResourceNotFoundException("AttendanceEntity", "id", id));
		if(attEntity!= null) {
			Calendar calendar = Calendar.getInstance();
	        java.util.Date now = calendar.getTime();
	        Timestamp currentTimestamp = new Timestamp(now.getTime());
			attEntity.setClockofftime(currentTimestamp);
				calculateDuration(attEntity);
			}
		return attendanceEntityRepository.save(attEntity);
	}

	private void calculateDuration(AttendanceEntity attEntity) {
		Date d1 = null;
		Date d2 = null;
		d1 = attEntity.getClockontime();
		d2 = attEntity.getClockofftime();
		// Get msec from each, and subtract.
		if(d1!=null && d2!=null ) {
			long diff = d2.getTime() - d1.getTime();
			long diffSeconds = diff / 1000;         
			long diffMinutes = diff / (60 * 1000);         
			long diffHours = diff / (60 * 60 * 1000);                      
			System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
			System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
			System.out.println("Time in hours: " + diffHours + " hours.");
			attEntity.setDurationminute(diffMinutes);
			attEntity.setDurationhours(diffHours);
		}	
	}


}
