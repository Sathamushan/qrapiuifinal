package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.StudentEntity;

public interface IStudentService {
	StudentEntity insertStudentDetails(StudentEntity studentEntity);
	StudentEntity updateStudentDetails(Long id, StudentEntity studentEntity);
}
