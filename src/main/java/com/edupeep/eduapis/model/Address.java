package com.edupeep.eduapis.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int add_id;
	//private long emp_id;
    private String street;
    private String city;
    private String state;
    private String zip;
    
    
    
    public Address() {
		
	}


	public Address(int add_id) {
    	this.add_id = add_id;
	}
    
   
	

	public int getAdd_id() {
		return add_id;
	}

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}

	public String getStreet() {
        return street;
    }
    
    public void setStreet(String address) {
        this.street = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
  


	public String toString() {
        return "Address id: " + getAdd_id() + 
               ", street: " + getStreet() +
               ", city: " + getCity() +
               ", state: " + getState() +
               ", zip: " + getZip();
    }

}