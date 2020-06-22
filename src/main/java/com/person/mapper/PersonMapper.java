package com.person.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.person.dataaccess.request.PersonRequestBody;
import com.person.dataaccess.response.PersonResponseBody;
import com.person.personapp.model.Person;

@Mapper
public abstract class PersonMapper {

public static final PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	public abstract PersonResponseBody map(final Person person);
	
	public abstract Person map(final PersonRequestBody personRequestBody);
}
