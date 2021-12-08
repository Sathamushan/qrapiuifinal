package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.MarksEntity;

public interface IMarkService {

	MarksEntity updateMarksData(Long id, MarksEntity marksEntityUpdate);
	
	
}

