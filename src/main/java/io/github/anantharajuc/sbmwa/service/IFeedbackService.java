package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.FeedBackEntity;

public interface IFeedbackService 
{
	FeedBackEntity saveFeedback(FeedBackEntity feedBackEntity);

	FeedBackEntity updateFeedback(Long id, FeedBackEntity feedBackUpdated);


}
