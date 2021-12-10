package io.github.anantharajuc.sbmwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.anantharajuc.sbmwa.model.MarksEntity;

@Repository
public interface MarksEntityRepository extends JpaRepository<MarksEntity, Long> {

}
