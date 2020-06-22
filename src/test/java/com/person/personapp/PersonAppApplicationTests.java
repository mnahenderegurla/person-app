package com.person.personapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import com.person.personapp.model.Person;
import com.person.repository.PersonRepository;
import com.person.service.PersonService;

@RunWith(MockitoJUnitRunner.class)
class PersonAppApplicationTests {

	@Mock
	PersonRepository personRepository;
	
	PersonService personService = new PersonService();
	List<Person> personList = new ArrayList<>();
	
	@Before
	public void setUp() {
		Person pOne = new Person();
		Person pTwo = new Person();
		personList.add(pOne);
		personList.add(pTwo);
	}
	
	@Test
	public void testListPersons() {
		when(personRepository.findAll()).thenReturn(personList);
		assertEquals(personService.listPersons().size(), 2);
	}

}
