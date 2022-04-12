package com.nativequery.nativequery.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.nativequery.nativequery.entity.Person;
import com.nativequery.nativequery.repository.PersonRepository;
import com.nativequery.nativequery.service.PersonDetailsService;

/**
 * @author Utsav Sharma
 *
 */
@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

	private static final Logger log = LoggerFactory.getLogger(PersonDetailsServiceImpl.class);

	@Autowired
	private PersonRepository personRepository;

	@Async
	public void savePersonDetailsService(Person person) {

		log.info("Saving person object:");

		personRepository.save(person);

		log.info("Saved person object");

//		Thread.currentThread().setName("save person details thread");
//
//		log.info(
//				"Entered savePersonDetailsService() method, it will run for 10 seconds, this method is run by this thread");
//		log.info("Thread name:" + Thread.currentThread().getName());
//
//		try {
//			Thread.sleep(10000);
//		} catch (Exception e) {
//
//		}
//
//		log.info("savePersonDetailsService() method has executed for 10 seconds");

	}

	@Override
	public List<Person> getPersonDetails(Integer personAge) {

		List<Person> person = personRepository.getPersonDetailsByAge(personAge);

		return person;

	}

	@Transactional
	public String updatePersonDetailsService(Person person, String personName) {

		log.info("Entered inside update person details method");

		personRepository.updatePersonDetailsByName(person.getPersonAge(), person.getPersonCity(),
				personName);

		log.info("Successfully executed the update method, now returning the response");

		return "ok";

	}

}
