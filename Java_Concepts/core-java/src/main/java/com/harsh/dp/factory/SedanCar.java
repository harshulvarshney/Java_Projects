package com.harsh.dp.factory;

public class SedanCar extends Car {
	
	public SedanCar() {
		super(CarType.Sedan);
		construct();
	}
 
    @Override
    protected void construct() {
        System.out.println("Building luxury car");
        // add accessories
    }

}
