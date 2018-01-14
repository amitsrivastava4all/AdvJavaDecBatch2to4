package com.brainmentors.items;

import java.util.Comparator;

public class SortByName implements Comparator<Item> {
	@Override
	public int compare(Item first, Item second){
		return first.getName().compareTo(second.getName());
	}
}


