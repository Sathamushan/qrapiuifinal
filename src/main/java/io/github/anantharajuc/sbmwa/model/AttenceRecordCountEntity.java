package io.github.anantharajuc.sbmwa.model;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AttenceRecordCountEntity {
	@Column(name="presentCount", nullable = true)
	int presentCount;
	
	@Column(name="absentCount", nullable = true)
	int absentCount;
	
	@Column(name="totalDaysCount", nullable = true)
	int totalDaysCount;

}
