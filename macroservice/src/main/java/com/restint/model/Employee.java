package com.restint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID")
	    private long id;
	    
	    @Column(name="FIRST_NAME")
	    private String firstName;
	    
	    @Column(name="LAST_NAME")
	    private String lastName;

	    
	    protected Employee(){}

	    public Employee(String firstName, String lastName){

	        this.firstName = firstName;
	        this.lastName = lastName;
	    }

	    public long getId() {
	        return id;
	    }

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setId(long id) {
			this.id = id;
		}

	   
	
}
