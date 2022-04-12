package com.nativequery.nativequery.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nativequery.nativequery.entity.Person;
import com.nativequery.nativequery.service.PersonDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
@Api(tags = { "Native Query Controller" })
public class NativeQueryController {

	private static final Logger log = LoggerFactory.getLogger(NativeQueryController.class);

	@Autowired
	private PersonDetailsService personDetailsService;

	@PostMapping(value = "/savePersonDetails")
	@ApiOperation(value = "It will executee the save person details service", notes = "execute save person service")
	@ApiResponses({ @ApiResponse(code = 200, message = "When it has successfully saved person entity"),
			@ApiResponse(code = 500, message = "When there is server side error") })
	public String savePersonDetailsController(@RequestBody Person person) {

//		Thread.currentThread().setName("main thread");

		personDetailsService.savePersonDetailsService(person);

//		log.info(
//				"save person details service is curently executing, returning response, this line is executed by this thread:"
//						+ Thread.currentThread().getName());

		return "ok";

	}

	@GetMapping(value = "/getPersonDetailsByAge/{age}")
	@ApiOperation(value = "It will executee the get person details by age service", notes = "execute get person details service")
	@ApiResponses({ @ApiResponse(code = 200, message = "When it has successfully fetched person details"),
			@ApiResponse(code = 500, message = "When there is server side error") })
	public List<Person> getPersonDetailsByAge(@PathVariable Integer age) {

		log.info("Entered inside get person details");
		List<Person> personList = personDetailsService.getPersonDetails(age);
		
		return personList;

	}

	@PutMapping(value="/updatePersonDetailsByName/{personName}")
	public String updatePersonDetails(@RequestBody Person person, @PathVariable String personName) {
		
		
		String response = personDetailsService.updatePersonDetailsService(person, personName);
		
		return response;
		

	}

}
