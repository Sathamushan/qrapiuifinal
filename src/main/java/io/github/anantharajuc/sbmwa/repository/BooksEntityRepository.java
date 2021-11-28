package io.github.anantharajuc.sbmwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.anantharajuc.sbmwa.model.BooksEntity;

public interface BooksEntityRepository extends JpaRepository<BooksEntity, Long>{
	

}
