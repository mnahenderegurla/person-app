package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.person.adapter.PersonAdapter;
import com.person.dataaccess.request.PersonRequestBody;
import com.person.dataaccess.request.UpdatePersonRequestBody;
import com.person.dataaccess.response.PersonResponseBody;
import com.person.exception.RecordNotFoundException;
import com.person.personapp.model.AddressRequestBody;
import com.person.personapp.model.AddressResponseBody;
import com.person.personapp.model.UpdateAddressRequestBody;
import com.person.personapp.model.UpdateAddressResponseBody;
import com.person.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/persons")
	public ResponseEntity<List<PersonResponseBody>> getAllPersons() {
		List<PersonResponseBody> list = personService.listPersons();
		list.stream().forEach(s -> System.out.println("yyyyyyyyyy " + s.getFirstName()));
		return new ResponseEntity<List<PersonResponseBody>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/person/{id}")
	public ResponseEntity<PersonResponseBody> getPersonById(@PathVariable("id") final String id)
			throws RecordNotFoundException {
		PersonResponseBody entity = personService.getPersonById(id);

		return new ResponseEntity<PersonResponseBody>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping(value = "/person/create")
	public ResponseEntity<PersonResponseBody> createPerson(@RequestBody final PersonRequestBody personRequestBody)
			throws RecordNotFoundException {
		System.out.println("PersonRequestBody111 " + personRequestBody.getId());
		PersonResponseBody updated = personService.createPerson(PersonAdapter.convert(personRequestBody));
		return new ResponseEntity<PersonResponseBody>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/person/update/{id}")
	public ResponseEntity<PersonResponseBody> updatePerson(@PathVariable("id") final String id, @RequestBody final UpdatePersonRequestBody updatePersonRequestBody)
			throws RecordNotFoundException {
		PersonResponseBody updated = personService.updatePerson(id, updatePersonRequestBody);
		return new ResponseEntity<PersonResponseBody>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/person/delete/{id}")
	public HttpStatus deletePersonById(@PathVariable("id") final String id) throws RecordNotFoundException {
		personService.deletePersonById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping(value = "/personsCount")
	public ResponseEntity<String> getNoOfPersons() {
		List<PersonResponseBody> list = personService.listPersons();

		return new ResponseEntity<String>(String.valueOf(list.size()), new HttpHeaders(), HttpStatus.OK);
	}

	
	@PostMapping(value = "/person/address/add")
	public ResponseEntity<AddressResponseBody> createPersonAddress(
			@RequestBody final AddressRequestBody addressRequestBody) throws RecordNotFoundException {
		AddressResponseBody updated = personService.createAddress(addressRequestBody);
		return new ResponseEntity<AddressResponseBody>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping(value = "/person/address/update/{id}")
	public ResponseEntity<UpdateAddressResponseBody> updatePersonAddress(@PathVariable("id") final String id,
			@RequestBody final UpdateAddressRequestBody updateAddressRequestBody) throws RecordNotFoundException {
		UpdateAddressResponseBody updated = personService.updateAddress(id, updateAddressRequestBody);
		return new ResponseEntity<UpdateAddressResponseBody>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/person/address/delete/{id}")
	public HttpStatus deleteAddressById(@PathVariable("id") final String id) throws RecordNotFoundException {
		personService.deleteAddressById(id);
		return HttpStatus.FORBIDDEN;
	}
}
