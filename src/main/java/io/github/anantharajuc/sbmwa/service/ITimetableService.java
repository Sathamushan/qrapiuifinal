package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.TimetableEntity;

public interface ITimetableService
{
	TimetableEntity saveTimetable(TimetableEntity timetableEntity);

	TimetableEntity updateTimetable(Long id, TimetableEntity timetableEntity);


}
