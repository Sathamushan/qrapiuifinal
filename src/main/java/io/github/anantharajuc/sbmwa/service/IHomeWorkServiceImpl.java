package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.HomeWorkEntity;

public interface IHomeWorkServiceImpl {

	HomeWorkEntity saveHomework(HomeWorkEntity homeWorkEntity);

	HomeWorkEntity updateHomework(Long id, HomeWorkEntity homeWorkEntity);

	

}
