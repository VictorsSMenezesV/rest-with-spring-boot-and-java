package br.com.ldf.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ldf.entity.Person;
import br.com.ldf.exceptions.ResourceNotFoundException;
import br.com.ldf.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger((PersonService.class.getName()));
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll(){
		
		logger.info("Finding all people!!");
		
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		logger.info("Finding one people");
		
		
		
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating  one person!");
		
	return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		
		Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
}
