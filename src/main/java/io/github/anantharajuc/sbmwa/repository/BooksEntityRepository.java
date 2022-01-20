package io.github.anantharajuc.sbmwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.model.BooksEntity;

public interface BooksEntityRepository extends JpaRepository<BooksEntity, Long>{

	@Query(value = "SELECT * FROM  books where classe= :classe",nativeQuery = true) 
	@Transactional(readOnly=true)
	List<BooksEntity> getUniqBooks(@Param("classe") String classe);
	

}
