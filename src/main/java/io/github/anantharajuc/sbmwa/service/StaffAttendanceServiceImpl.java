package io.github.anantharajuc.sbmwa.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.StaffAttendanceEntity;
import io.github.anantharajuc.sbmwa.model.StaffsEntity;
import io.github.anantharajuc.sbmwa.repository.StaffAttendanceEntityRepository;
import io.github.anantharajuc.sbmwa.repository.StaffsEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StaffAttendanceServiceImpl	 implements IStaffAttendanceService
{
	@Autowired
	private StaffAttendanceEntityRepository staffattendanceEntityRepository;
	@Autowired
	private StaffsEntityRepository  staffEntityRepository;

	@Override
	public StaffAttendanceEntity insertstaffAttandanceDetails(StaffAttendanceEntity attendanceEntity) 
	{
		log.info("-----> saveAttendanceDetails serviceImpl");
		  
		log.info("-----> attendanceEntity "+ attendanceEntity.getAttendancestatus());
		StaffAttendanceEntity attEntity = new StaffAttendanceEntity ();
		if(attendanceEntity != null) {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
			getStaffData(attEntity,attendanceEntity.getId());
			attEntity.setClockontime(new Date());	
			attEntity.setClockofftime(null);
			attEntity.setBreaktime(attendanceEntity.getBreaktime());
			attEntity.setSchoolcode(attendanceEntity.getSchoolcode());
			attEntity.setDurationhours(attendanceEntity.getDurationhours());
			attEntity.setDurationminute(attendanceEntity.getDurationminute());
			attEntity.setAttendancestatus(attendanceEntity.getAttendancestatus());
			attEntity.setCurrentdate(date);
		}
		return staffattendanceEntityRepository.save(attEntity);
	}

	private void getStaffData(StaffAttendanceEntity attEntity, Long staffid) {
		StaffsEntity staffEntityResult = staffEntityRepository.findById(staffid)
				.orElseThrow(() -> new ResourceNotFoundException("StaffEntity", "id", staffid));
		if(staffEntityResult != null) {
			attEntity.setId(staffEntityResult.getId());
			attEntity.setName(staffEntityResult.getName());
			attEntity.setDepartment(staffEntityResult.getDepartment());
			attEntity.setDesignation(staffEntityResult.getDesignation());	
		}
	}

	@Override
	public StaffAttendanceEntity updatestaffAttandanceDetails(Long id, StaffAttendanceEntity attenEntityUpdated) {
		log.info("-----> updateAttandanceDetails serviceImpl");
		StaffAttendanceEntity attEntity = staffattendanceEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("StaffAttendanceEntity", "id", id));
		if(attEntity!= null) {
			getStaffData(attEntity,id);
			attEntity.setClockontime(attenEntityUpdated.getClockontime());	
			attEntity.setClockofftime(attenEntityUpdated.getClockofftime());
			attEntity.setBreaktime(attenEntityUpdated.getBreaktime());
			attEntity.setAttendancestatus(attenEntityUpdated.getAttendancestatus());
		}
		return staffattendanceEntityRepository.save(attEntity);
	}

	public void deleteAttandance(Long id) {

		log.info("-----> deleteAttandance serviceImpl");
		staffattendanceEntityRepository.deleteById(id);
		StaffAttendanceEntity attendanceEntity = staffattendanceEntityRepository.getById(id);
		if(attendanceEntity!=  null) {
			staffattendanceEntityRepository.deleteById(id);
		}
	}
	
	
	@Override
	public StaffAttendanceEntity updatestaffAttandanceById(Long studId) {
		log.info("-----> updateAttandanceById serviceImpl");
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		System.out.println(date);
		StaffAttendanceEntity attEntity = staffattendanceEntityRepository.getStaffById(studId, date);
				//.orElseThrow(() -> new ResourceNotFoundException("AttendanceEntity", "id", id));
		if(attEntity!= null) {
			Calendar calendar = Calendar.getInstance();
	        java.util.Date now = calendar.getTime();
	        Timestamp currentTimestamp = new Timestamp(now.getTime());
			attEntity.setClockofftime(currentTimestamp);
				calculateDuration(attEntity);
			}
		return staffattendanceEntityRepository.save(attEntity);
	}

	private void calculateDuration(StaffAttendanceEntity attEntity) {
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
