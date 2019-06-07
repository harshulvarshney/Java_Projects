package com.java.thread.parkingSystem;

public class Parking {
	
	private final int CAP = 10;
	private int carsParked = 0;
	
	private void parkCar() {
		synchronized (this) {
			if(carsParked <= CAP)
				carsParked++;
		}
	}

	private void removeCar() {
		synchronized (this) {
			if(carsParked > 0) {
				carsParked--;
			}
		}
	}
}
