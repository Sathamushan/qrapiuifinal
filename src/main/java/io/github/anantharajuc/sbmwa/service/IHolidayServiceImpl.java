package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.HolidayEntity;

public interface IHolidayServiceImpl {

	HolidayEntity saveHoliday(HolidayEntity holidayEntity);

	HolidayEntity updateHolidayData(Long id, HolidayEntity holidayEntity);

}
