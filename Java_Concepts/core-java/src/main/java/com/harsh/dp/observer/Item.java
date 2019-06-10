package com.harsh.dp.observer;

import java.util.Observable;

public class Item extends Observable {
	
	private int count;
	
	public boolean inStock() {
		return count > 0 ? true : false;
	}
	
	public void addItem() {
		if(count == 0) {
			setChanged();
			notifyObservers();
		}
		count++;
	}


}
