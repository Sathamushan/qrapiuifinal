package io.github.anantharajuc.sbmwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.FeedBackEntity;
import io.github.anantharajuc.sbmwa.repository.FeedBackEntityRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@CrossOrigin
public class FeedbackServiceImpl implements IFeedbackService
{
	@Autowired
	private FeedBackEntityRepository feedBackEntityRepository;

	
	@Override
	public FeedBackEntity saveFeedback(FeedBackEntity feedBackEntity) 
	{
		log.info("-----> saveFeedback serviceImpl");
		log.info("-----> feedBackEntity "+ feedBackEntity.getParentname());
		return feedBackEntityRepository.save(feedBackEntity);
	}
	
	/*public FeedBackEntity updateFeedback(FeedBackEntity feedBackUpdated) {
		log.info("-----> updateFeedback serviceImpl");
		log.info("-----> feedBackEntity "+ feedBackUpdated.getParentname());

		FeedBackEntity feedBackdata = feedBackEntityRepository
				.findById(feedBackUpdated.getId())
				.orElseThrow(() -> new ResourceNotFoundException("FeedBackEntity", "id", feedBackUpdated.getId()));

		feedBackdata.setParentname(feedBackUpdated.getParentname());
		feedBackdata.setStudentname(feedBackUpdated.getStudentname());
		feedBackdata.setClasse(feedBackUpdated.getClasse());
		feedBackdata.setFeedbackdescription(feedBackUpdated.getFeedbackdescription());
		feedBackdata.setSection(feedBackUpdated.getSection());
		return feedBackEntityRepository.save(feedBackdata);
	}
	*/
	
	
	public void deletefb(Long id) {
		feedBackEntityRepository.deleteById(id);
	}

	@Override
	public FeedBackEntity updateFeedback(Long id, FeedBackEntity feedBackUpdated) {
		log.info("-----> updateFeedback serviceImpl");
		log.info("-----> feedBackEntity "+ feedBackUpdated.getParentname());

		FeedBackEntity feedBackdata = feedBackEntityRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FeedBackEntity", "id", id));
		if(feedBackdata!= null) {
			feedBackdata.setParentname(feedBackUpdated.getParentname());
			feedBackdata.setStudentname(feedBackUpdated.getStudentname());
			feedBackdata.setClasse(feedBackUpdated.getClasse());
			feedBackdata.setFeedbackdescription(feedBackUpdated.getFeedbackdescription());
			feedBackdata.setSection(feedBackUpdated.getSection());	
		}
		return feedBackEntityRepository.save(feedBackdata);
	}
	
	@Override
	public void updateFeedbackStatus(Long id, String fbStatus, String fbresponce) {
		log.info("-----> updateFeedbackStatus serviceImpl");
		 feedBackEntityRepository.updateFeedbackStatus(fbStatus,fbresponce,id);
	}
	
	
}
