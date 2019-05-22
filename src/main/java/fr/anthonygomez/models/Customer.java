package fr.anthonygomez.models;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

	private int id;
	private String name;
	private String surname;
	private Collection<Customer> friends = new ArrayList<Customer>();
	
	public Customer(int id, String name, String surname, Collection<Customer> friends) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.friends = friends;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	public Collection<Customer> getFriends() {
		return friends;
	}
	
}
