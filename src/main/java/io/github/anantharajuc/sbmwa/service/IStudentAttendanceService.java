package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.StudentAttendanceEntity;

public interface IStudentAttendanceService {
	
	StudentAttendanceEntity insertAttandanceDetails(StudentAttendanceEntity attendanceEntity);

	StudentAttendanceEntity updateAttandanceDetails(Long id, StudentAttendanceEntity attenEntityUpdated);
	
	StudentAttendanceEntity updateAttandanceById(Long id);
	
}
