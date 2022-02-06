package io.github.anantharajuc.sbmwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.FeedBackEntity;


@Repository
public interface FeedBackEntityRepository extends JpaRepository<FeedBackEntity, Long> { 
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE feedback SET fbstatus= :fbCStatus,fbresponce=:fbres WHERE id= :fbId",nativeQuery = true) 
	 @Transactional(readOnly=false)
	void updateFeedbackStatus(@Param("fbCStatus") String fbCStatus,@Param("fbres") String fbres,@Param("fbId")Long fbId);

	@Query(value = "SELECT * FROM  feedback where studentid= :studId",nativeQuery = true) 
	@Transactional(readOnly=true)
	List<FeedBackEntity> getfbByStudId(@Param("studId") String studId);
}
