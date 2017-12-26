package com.brainmentors.items;

public class Item {
	private int id;
	private String name;
	private double price;
	private int quantity;
	public Item(){}
	public Item(int id , String name, double price, int quantity){
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		System.out.println();
	}
	
	@Override
	public boolean equals(Object object){
//		int x = 100;
//		byte e = (byte) x;
		if(object instanceof Item){
			
			Item item = (Item) object; // Downcasting
			if(this.id>0 && this.name!=null && this.name.trim().length()>0){
				if(this.id == item.id && this.name.equals(item.name)){
					return true;
				}
			}
			else
			if(item.name!=null && item.name.trim().length()>0){
				if(this.name.equals(item.name)){
					return true;
				}
			}
			else
			if(item.id>0){
			if(this.id == item.id){
				return true;
			}
			}
		}
		return false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	


}
