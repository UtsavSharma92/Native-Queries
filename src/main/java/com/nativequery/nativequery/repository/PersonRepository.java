package com.nativequery.nativequery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nativequery.nativequery.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query(value = "select * from Person where person_age = (:persAge)", nativeQuery = true)
	public List<Person> getPersonDetailsByAge(@Param("persAge") Integer persAge);
	
	@Modifying
	@Query(value = "update Person set person_age = :persAge, person_city = :persCity where person_name = :persName", nativeQuery = true)
	public void updatePersonDetailsByName(Integer persAge, String persCity, String persName);

}
