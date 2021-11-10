package io.github.anantharajuc.sbmwa.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import io.github.anantharajuc.sbmwa.model.Address;
import lombok.AccessLevel;
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class PersonDTO 
{
	Long id;
	String name;
	String email;
	String mobileNumber;
	Address address;
}