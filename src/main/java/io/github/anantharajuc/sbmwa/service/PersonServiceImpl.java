package io.github.anantharajuc.sbmwa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.model.Address;
import io.github.anantharajuc.sbmwa.model.Person;
import io.github.anantharajuc.sbmwa.repository.AddressRepository;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PersonServiceImpl implements PersonService
{
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<Person> getAllPersons() 
	{
		log.info("-----> getAllPersons service");
		
		return personRepository.findAll();
    }
	
	public Person getPersonById(Long id) 
	{
		log.info("-----> getPersonById service");
		
		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }
	
	public Person savePerson(Person person) 
	{
		log.info("-----> saveOrUpdate service"+person);
		
        return personRepository.save(person);
    }
	
	public ResponseEntity<?> delete(Long id) 
	{
		log.info("-----> delete service");
		
		Person person = personRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		
		personRepository.delete(person); 
		
		return ResponseEntity
				.ok()
				.build();
    }

	@Override
	public Person updatePerson(Long id, Person personDetails) 
	{
		log.info("-----> updatePerson service");
		
		Person person = personRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		
		person.setName(personDetails.getName());
		person.setEmail(personDetails.getEmail()); 
		person.setMobileNumber(personDetails.getMobileNumber()); 	
		
		Address address = addressRepository.findById(person.getAddress().getId())
				            .orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));
		
		address.setCity(personDetails.getAddress().getCity());
		address.setZipcode(personDetails.getAddress().getZipcode());
		
		addressRepository.save(address);
		
		//person.setAddress(personDetails.getAddress().getId()); 

		return personRepository.save(person);
	}
}