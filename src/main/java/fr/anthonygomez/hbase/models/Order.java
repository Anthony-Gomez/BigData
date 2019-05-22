package fr.anthonygomez.hbase.models;

public class Order {
	
	private Product product;
	private Customer customer;
	private int id;
	
	public Order(int id,Product product, Customer customer) {
		this.product = product;
		this.customer = customer;
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public int getId() {
		return id;
	}

}
