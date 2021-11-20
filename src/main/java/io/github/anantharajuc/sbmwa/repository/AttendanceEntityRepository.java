package io.github.anantharajuc.sbmwa.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.AttendanceEntity;
@Repository
public interface AttendanceEntityRepository extends JpaRepository<AttendanceEntity, Long>
{
	@Query(value = "SELECT * FROM attendance WHERE studentid = :studentid and currentdate = :currentdate",nativeQuery = true) 
	@Transactional(readOnly=true)
	AttendanceEntity getStudentById(@Param("studentid") Long studId, @Param("currentdate") Date date);

}
