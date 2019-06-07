package com.harsh.dp.factory;

/**
 * It is a creational pattern, based on inheritance.
 * 
 * Factory returns a Factory Method (interface) which in turn returns Concrete Object
 * 
 * we can substitute new Concrete Objects for interface and client (caller) should 
 * not be aware of all concrete implementations, Client always access interface only 
 * and you can hide object creation details in Factory method.
 * 
 * 
 * @author harshul.varshney
 *
 */
public class CarFactory implements IcarFactory {
	
	@Override
	public Car buildCar(CarType model) {
        Car car = null;
        switch (model) {
        case Mini:
            car = new SmallCar();
            break;
 
        case Sedan:
            car = new SedanCar();
            break;
 
        default:
            // throw some exception
            break;
        }
        return car;
    }

}
