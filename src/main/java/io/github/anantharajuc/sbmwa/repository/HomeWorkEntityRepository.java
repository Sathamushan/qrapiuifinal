package io.github.anantharajuc.sbmwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.HomeWorkEntity;

@Repository
public interface HomeWorkEntityRepository  extends JpaRepository<HomeWorkEntity, Long> {

	@Query(value = "SELECT * FROM  homework where classe= :classe and section = :section",nativeQuery = true) 
	@Transactional(readOnly=true)
	List<HomeWorkEntity> getHomeworkData(@Param("classe") String classe,@Param("section") String section);

}
