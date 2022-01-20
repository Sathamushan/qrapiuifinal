package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.LeaveEntity;

public interface ILeaveService 
{
	LeaveEntity saveLeave(LeaveEntity leaveEntity);
	LeaveEntity updateLeave(Long id, LeaveEntity leaveEntityUpdated);


}
