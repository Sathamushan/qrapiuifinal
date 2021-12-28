package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.BooksEntity;
import io.github.anantharajuc.sbmwa.repository.BooksEntityRepository;
import lombok.extern.log4j.Log4j2;


@RequestMapping("/smjh/books")
@Log4j2
@RestController
@CrossOrigin
public class BooksQueryController 
{
	@Autowired
	private BooksEntityRepository booksEntityRepository;
	
	
	@GetMapping()	
	public List<BooksEntity> findBooks()
	{
		return booksEntityRepository.findAll();
	}
	
	
	@GetMapping("/{id}")	
	public BooksEntity findBookById(@PathVariable(value="id") Long id)
	{
		log.info("-----> QueryController find by Id");
		return booksEntityRepository.findById(id).get();  
	}

}
