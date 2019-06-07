package com.harsh.dp.factory;

public class SmallCar extends Car {
	
	SmallCar() {
        super(CarType.Mini);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building small car");
        // add accessories
    }

}
