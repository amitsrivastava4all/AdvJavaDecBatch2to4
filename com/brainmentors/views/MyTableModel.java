package com.brainmentors.views;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.brainmentors.items.Item;
import com.brainmentors.items.ItemOperations;

public class MyTableModel extends AbstractTableModel{
	private String []colNames= {"id","name","price","quantity"};	
	private ArrayList<Item> itemList;
	public MyTableModel(){
		itemList = ItemOperations.getInstance().getItems();
	}
	
	@Override
	public int getColumnCount() {
	     return colNames.length;
	    }
	@Override
	    public int getRowCount() {
	      return itemList.size();
	    }
	@Override
	    public Object getValueAt(int row, int col) {
	    Item item = itemList.get(row);
	    System.out.println("ROw is "+row+" Col is "+col);
	    switch(col){
	    case 0:
	    		return item.getId();
	    		
	    case 1:
	    		return item.getName();
	    case 2:
	    	return item.getPrice();
	    case 3:
	    	return item.getQuantity();
	    default:
	    	return null;
	    }
	    }

	    @Override
	    public String getColumnName(int col) {
	        return colNames[col];
	      }
	    
	    }
