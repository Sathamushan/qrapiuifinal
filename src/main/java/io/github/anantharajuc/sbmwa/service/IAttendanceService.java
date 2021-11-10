package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.AttendanceEntity;

public interface IAttendanceService {
	
	AttendanceEntity insertAttandanceDetails(AttendanceEntity attendanceEntity);

	AttendanceEntity updateAttandanceDetails(Long id, AttendanceEntity attenEntityUpdated);
	
	AttendanceEntity updateAttandanceById(Long id);
	
}
