package io.github.anantharajuc.sbmwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.model.FeedBackEntity;
import io.github.anantharajuc.sbmwa.service.FeedbackServiceImpl;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/smjh/feedback")
@Log4j2
public class FeedBackCommandController 
{
	@Autowired
	private FeedbackServiceImpl feedbackServiceImpl;
	
	@PostMapping("/insert")
	public FeedBackEntity saveFeedback(@RequestBody FeedBackEntity feedBackEntity)
	{
		log.info("-----> saveFeedback controller");
		log.info("-----> feedBackEntity "+ feedBackEntity.getParentname());
		
		return feedbackServiceImpl.saveFeedback(feedBackEntity);
	}
	
	
	@PostMapping("/delete/{id}")
	public void deleteFeedback(@PathVariable("id") Long id)
	{
		feedbackServiceImpl.deletefb(id);
	}
	
	@PostMapping("/update/{id}")
	public FeedBackEntity updateFeedbackData(@PathVariable("id") Long id,@RequestBody FeedBackEntity feedBackEntity)
	{		
		return feedbackServiceImpl.updateFeedback(id,feedBackEntity);
	}
	
	/*public FeedBackEntity updateFeedbackData(@PathVariable(value="id") Long id,@Valid @RequestBody FeedBackEntity feedBackEntity)
	{		
		return feedbackServiceImpl.updateFeedback(id, feedBackEntity);
	}*/
	
	/*@PostMapping("/delete/{id}")
	public ResponseEntity<?>  deleteFeedBack(@PathVariable(value="id") Long id) 
	{
		log.info("-----> saveFeedback controller");
		
		return new ResponseEntity<>(feedbackServiceImpl.deleteFeedBack(id),HttpStatus.NO_CONTENT);

	}*/
	
	
	
}
