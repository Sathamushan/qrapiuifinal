package io.github.anantharajuc.sbmwa.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.StudentAttendanceEntity;

@Repository
public interface StudentAttendanceEntityRepository extends JpaRepository<StudentAttendanceEntity, Long>
{
	@Query(value = "SELECT * FROM studentattendance WHERE studentid = :studentid and currentdate = :currentdate",nativeQuery = true) 
	@Transactional(readOnly=true)
	StudentAttendanceEntity getStudentById(@Param("studentid") Long studId, @Param("currentdate") Date date);

}
