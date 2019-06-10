package com.harsh.dp.observer;

import java.util.Observable;
import java.util.Observer;

public class Notifier implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Notificatio for users: item is now available.");
	}

}
