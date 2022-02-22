package com.javasampleapproach.springrest.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;


	@Column(name = "email")
	private String email ;

	public Customer(String name, String email ) {
		this.name = name;
		this.email = email;
	}

	public Customer() {
	}


	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", " + " email="+ email +" ]";
	}
}
