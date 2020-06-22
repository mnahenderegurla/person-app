package com.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.person.personapp.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, String>{

}
