package io.github.anantharajuc.sbmwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.StaffsEntity;

@Repository
public interface StaffsEntityRepository extends JpaRepository<StaffsEntity, Long>{
	
	@Query(value = "SELECT * FROM  staffs where classe= :classe and section = :section",nativeQuery = true) 
	@Transactional(readOnly=true)
	StaffsEntity getClassByStudId(@Param("classe") String classe,@Param("section") String section);

}
