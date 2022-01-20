package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.StaffAttendanceEntity;

public interface IStaffAttendanceService {
	
	StaffAttendanceEntity insertstaffAttandanceDetails(StaffAttendanceEntity attendanceEntity);

	StaffAttendanceEntity updatestaffAttandanceDetails(Long id, StaffAttendanceEntity attenEntityUpdated);
	
	StaffAttendanceEntity updatestaffAttandanceById(Long id);
	
}
