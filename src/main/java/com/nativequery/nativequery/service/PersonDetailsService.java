package com.nativequery.nativequery.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nativequery.nativequery.entity.Person;

public interface PersonDetailsService {
	
	//@Query(value="insert into person(personName, personAge, personState, personCity, personHobby) values()")
	public void savePersonDetailsService(Person person);
	
	public List<Person> getPersonDetails(Integer personAge);
	
	public String updatePersonDetailsService(Person person, String personName);

}
