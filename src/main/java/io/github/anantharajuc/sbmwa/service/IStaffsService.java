package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.StaffsEntity;

public interface IStaffsService {
	StaffsEntity updatestaffData(Long id, StaffsEntity booksEntityUpdate);
	StaffsEntity saveStaffDetails(StaffsEntity staffsEntity);
	
}

