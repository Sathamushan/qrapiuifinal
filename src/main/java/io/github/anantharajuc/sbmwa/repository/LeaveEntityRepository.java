package io.github.anantharajuc.sbmwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.LeaveEntity;


@Repository
public interface LeaveEntityRepository extends JpaRepository<LeaveEntity, Long> {


	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE leavedetails SET approvalstatus= :status WHERE id= :leaveId",nativeQuery = true) 
	@Transactional(readOnly=false)
	void updateLeaveStatus(@Param("status") String status,@Param("leaveId")Long leaveId);
	
	@Query(value = "SELECT * FROM  leavedetails where studentid= :studId",nativeQuery = true) 
	@Transactional(readOnly=true)
	List<LeaveEntity> getleaveDataByStudId(@Param("studId") String studId);
}
