package com.person.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.adapter.PersonAdapter;
import com.person.dataaccess.request.UpdatePersonRequestBody;
import com.person.dataaccess.response.PersonResponseBody;
import com.person.exception.RecordNotFoundException;
import com.person.personapp.model.Address;
import com.person.personapp.model.AddressRequestBody;
import com.person.personapp.model.AddressResponseBody;
import com.person.personapp.model.Person;
import com.person.personapp.model.UpdateAddressRequestBody;
import com.person.personapp.model.UpdateAddressResponseBody;
import com.person.repository.AddressRepository;
import com.person.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressRepository addressRepository;
     
    public List<PersonResponseBody> listPersons()
    {
        List<Person> personList = personRepository.findAll();
        if(personList.size() > 0) {
            return personList.stream().map(PersonAdapter::convert).collect(Collectors.toList());
        } else {
            return new ArrayList<PersonResponseBody>();
        }
    }
     
    public PersonResponseBody getPersonById(String id) throws RecordNotFoundException
    {
        Optional<Person> employee = personRepository.findById(id);
         
        if(employee.isPresent()) {
            return PersonAdapter.convert(employee.get());
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public PersonResponseBody createPerson(Person entity) throws RecordNotFoundException
    {
        Optional<Person> person = personRepository.findById(entity.getId());
         
        if(person.isPresent())
        {
        	Person newEntity = person.get();
            newEntity.setId(entity.getId());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = personRepository.save(newEntity);
             
            return PersonAdapter.convert(newEntity);
        } else {
            entity = personRepository.save(entity);
             
            return PersonAdapter.convert(entity);
        }
    }
    
    public PersonResponseBody updatePerson(String id, UpdatePersonRequestBody entity) throws RecordNotFoundException
    {
        Optional<Person> person = personRepository.findById(id);
         
        if(person.isPresent())
        {
        	Person updateEntity = person.get();
        	updateEntity.setId(id);
        	updateEntity.setFirstName(entity.getFirstName());
        	updateEntity.setLastName(entity.getLastName());
 
        	updateEntity = personRepository.save(updateEntity);
             
            return PersonAdapter.convert(updateEntity);
        } else {
        	throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public void deletePersonById(String id) throws RecordNotFoundException
    {
        Optional<Person> employee = personRepository.findById(id);
         
        if(employee.isPresent())
        {
        	personRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
    public void deleteAddressById(String id) throws RecordNotFoundException
    {
        Optional<Address> address = addressRepository.findById(id);
         
        if(address.isPresent())
        {
        	addressRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No address record exist for given id");
        }
    }
    
    public AddressResponseBody createAddress(AddressRequestBody entity) throws RecordNotFoundException
    {
        Optional<Person> person = personRepository.findById(entity.getPid());
        AddressResponseBody addressResponseBody = new AddressResponseBody();
        addressResponseBody.setPid(entity.getPid());
        List<Address> addresses = new ArrayList<>();
        for(Address address:entity.getAddresses()) {
        	Optional<Address> addressProx = addressRepository.findById(address.getId());
        	if(addressProx.isPresent())
            {
            	Address newEntity = addressProx.get();
                newEntity.setId(address.getId());
                newEntity.setCity(address.getCity());
                newEntity.setStreet(address.getStreet());
                newEntity.setState(address.getState());
                newEntity.setPostal(address.getPostal());
                newEntity.setPerson(person.get());
                newEntity = addressRepository.save(newEntity);
                addresses.add(newEntity);
            } else {
            	address.setPerson(person.get());
            	address = addressRepository.save(address);
            	addresses.add(address);
            }
        }
        addressResponseBody.setAddresses(addresses);
         return addressResponseBody;
    }
    
    public UpdateAddressResponseBody updateAddress(String id, UpdateAddressRequestBody updateAddressRequestBody) throws RecordNotFoundException
    {
        Optional<Address> address = addressRepository.findById(id);
        UpdateAddressResponseBody updateAddressResponseBody = new UpdateAddressResponseBody();
        if(address.isPresent())
        {
        	Address updateEntity = address.get();
        	updateEntity.setId(id);
        	updateEntity.setCity(updateAddressRequestBody.getCity());
        	updateEntity.setState(updateAddressRequestBody.getState());
        	updateEntity.setStreet(updateAddressRequestBody.getStreet());
        	updateEntity.setPostal(updateAddressRequestBody.getPostal());
 
        	updateEntity = addressRepository.save(updateEntity);
        	updateAddressResponseBody.setCity(updateEntity.getCity());
        	updateAddressResponseBody.setPostal(updateEntity.getPostal());
        	updateAddressResponseBody.setState(updateEntity.getState());
        	updateAddressResponseBody.setStreet(updateEntity.getState());
            return updateAddressResponseBody;
        } else {
        	throw new RecordNotFoundException("No Address record exist for given id");
        }
    }
}
