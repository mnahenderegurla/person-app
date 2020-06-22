package com.person.adapter;
import com.person.dataaccess.request.PersonRequestBody;
import com.person.dataaccess.response.PersonResponseBody;
import com.person.mapper.PersonMapper;
import com.person.personapp.model.Person;

public class PersonAdapter {

	private static PersonMapper personMapper = PersonMapper.INSTANCE;
	
	public static Person convert(final PersonRequestBody personRequestBody) {
		/*Person person = new Person();
		person.setId(request.getId());
		person.setFirstName(request.getFirstName());
		person.setLastName(request.getLastName());*/
        return personMapper.map(personRequestBody);
    }

    public static PersonResponseBody convert(final Person person) {
        return personMapper.map(person);
    }
}
