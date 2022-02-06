package io.github.anantharajuc.sbmwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.MarksEntity;

@Repository
public interface MarksEntityRepository extends JpaRepository<MarksEntity, Long> {

	
	@Query(value = "SELECT * FROM  marks where studentid= :studId",nativeQuery = true) 
	@Transactional(readOnly=true)
	List<MarksEntity> getmarkByStudId(@Param("studId") String studId);

}
