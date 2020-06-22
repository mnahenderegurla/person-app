package com.person.personapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	    private String id;
	    private String firstName;
	    private String lastName;
	    @OneToMany(targetEntity=Address.class, fetch = FetchType.LAZY, mappedBy="person", cascade = CascadeType.ALL, orphanRemoval = true)
	    List<Address> addresses;
	    
	    public Person() {

	    }
	    public Person(String firstName, String lastName, String id) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.id = id;
	    }

	    @Id
	    @Column(name = "pid", nullable = false)
	    public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }

	    @Column(name = "first_name")
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    @Column(name = "last_name")
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

}
