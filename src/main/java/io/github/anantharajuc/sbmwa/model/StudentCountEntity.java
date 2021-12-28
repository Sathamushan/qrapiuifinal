package io.github.anantharajuc.sbmwa.model;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentCountEntity {
	@Column(name="tot", nullable = true)
	int tot;
	@Column(name="male", nullable = true)
	int male;
	
	@Column(name="female", nullable = true)
	int female;

}
