package io.github.anantharajuc.sbmwa.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.StaffAttendanceEntity;

@Repository
public interface StaffAttendanceEntityRepository extends JpaRepository<StaffAttendanceEntity, Long>
{
	@Query(value = "SELECT * FROM staffattendance WHERE staffid = :staffid and currentdate = :currentdate",nativeQuery = true) 
	@Transactional(readOnly=true)
	StaffAttendanceEntity getStaffById(@Param("staffid") Long studId, @Param("currentdate") Date date);

}
