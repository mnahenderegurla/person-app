package com.person.personapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	private String id;
    private String street;
    private String city;
    private String state;
    private String postal;

    public Address() {

    }
    public Address(String id, String street, String city, String state, String postal) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal = postal;
    }

    private Person person;
    
    @Id
    @Column(name = "aid", nullable = false)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
    @Column(name = "postal")
    public String getPostal() {
        return postal;
    }
    public void setPostal(String postal) {
        this.postal = postal;
    }
    
    @Column(name = "city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="pid")
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
    
}
