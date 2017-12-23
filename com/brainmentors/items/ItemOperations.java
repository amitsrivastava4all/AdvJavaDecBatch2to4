package com.brainmentors.items;

import java.util.ArrayList;

public class ItemOperations {
	private ItemOperations(){}
	private ArrayList<Item> itemList = new ArrayList<>();
	private static ItemOperations itemOperations;
	public String addItem(Item item){
		this.itemList.add(item);
		return "Item Added...";
	}
	
	public ArrayList<Item> getItems(){
		return itemList;
	}
	
	public static ItemOperations getInstance(){
		if(itemOperations==null){
			itemOperations = new ItemOperations();
		}
		return itemOperations;
	}

}
