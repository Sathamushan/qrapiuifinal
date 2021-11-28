package io.github.anantharajuc.sbmwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.FeedBackEntity;
import io.github.anantharajuc.sbmwa.repository.FeedBackEntityRepository;

@RestController
@RequestMapping("/smjh/feedback")
public class FeedBackQueryController 
{
	@Autowired
	private FeedBackEntityRepository feedBackEntityRepository;
	
	@GetMapping()	
	public List<FeedBackEntity> findAllFeedBack()
	{
		return feedBackEntityRepository.findAll();
	}
	
	@GetMapping("/{id}")	
	public FeedBackEntity findAllFeedBackById(@PathVariable(value="id") Long id)
	{
		return feedBackEntityRepository.findById(id).get();
	}

}
