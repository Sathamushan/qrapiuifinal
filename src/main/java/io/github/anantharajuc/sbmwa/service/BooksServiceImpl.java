package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.BooksEntity;
import io.github.anantharajuc.sbmwa.repository.BooksEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BooksServiceImpl implements IBooksService{
	
	@Autowired
	private BooksEntityRepository booksEntityRepository;

	public BooksEntity saveBookDetails(BooksEntity booksEntity) {
		
		log.info("-----> saveBookDetails serviceImpl");
		log.info("-----> booksEntity "+ booksEntity.getStudentname());
		return booksEntityRepository.save(booksEntity);
	}

	@Override
	public BooksEntity updateBookData(Long id, BooksEntity booksEntityUpdate) {
		log.info("-----> updateBook serviceImpl");
		BooksEntity booksEntityResult = booksEntityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BooksEntity", "id", id));
		
		if(booksEntityResult!= null) {
			booksEntityResult.setParentname(booksEntityUpdate.getParentname());
			booksEntityResult.setStudentname(booksEntityUpdate.getStudentname());
			booksEntityResult.setClasse(booksEntityUpdate.getClasse());
			booksEntityResult.setDownloadurl(booksEntityUpdate.getDownloadurl());
			booksEntityResult.setSection(booksEntityUpdate.getSection());	
			booksEntityResult.setSubject(booksEntityUpdate.getSubject());	
		}
		return booksEntityRepository.save(booksEntityResult);
	}
	
	
	public void deleteBooks(Long id) {
		log.info("-----> deleteBooks serviceImpl");
		BooksEntity booksEntity = booksEntityRepository.getById(id);
		if(booksEntity!=  null) {
			booksEntityRepository.deleteById(id);
		}
	}


	

}
