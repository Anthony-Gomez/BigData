package fr.anthonygomez.hbase.models;

public class Product {
	
	private int id;
	private String label;
	
	public Product(int id, String label) {
		super();
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	public String getLabel() {
		return label;
	}
		
}
