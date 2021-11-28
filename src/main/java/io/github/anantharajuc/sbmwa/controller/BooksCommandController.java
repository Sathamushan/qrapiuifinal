package io.github.anantharajuc.sbmwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.BooksEntity;
import io.github.anantharajuc.sbmwa.service.BooksServiceImpl;
import lombok.extern.log4j.Log4j2;


@RequestMapping("/smjh/books")
@Log4j2
@RestController
public class BooksCommandController {
	
		
	@Autowired
	private BooksServiceImpl booksServiceImpl;
	
	
	@PostMapping("/insert")
	public BooksEntity saveBookDetails(@RequestBody BooksEntity booksEntity)
	{
		log.info("-----> saveBookDetails controller");
		log.info("-----> booksEntity "+ booksEntity.getParentname());
		return booksServiceImpl.saveBookDetails(booksEntity);
	}
	
	
	@PostMapping("/update/{id}")
	public BooksEntity updateBook(@PathVariable("id") Long id,@RequestBody BooksEntity booksEntity)
	{	
		log.info("-----> updateBook controller");
		return booksServiceImpl.updateBookData(id,booksEntity);
	}
	
	
	
	@PostMapping("/delete/{id}")
	public void deleteBooks(@PathVariable("id") Long id)
	{
		log.info("-----> deleteBooks controller");
		booksServiceImpl.deleteBooks(id);
	}

	

}
