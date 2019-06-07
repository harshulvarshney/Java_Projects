package com.harsh.sp.template;

import java.util.HashMap;
import java.util.Map;

/**
 * It is a behavioral design pattern.
 * It defines the program skeleton of an algorithm in an operation, deferring some steps to subclasses.
 * 
 * It lets one redefine certain steps of an algorithm without changing the algorithm's structure.
 * The template method pattern promotes code reuse and decoupling, but at the expense of using inheritance.
 * 
 * java.util.AbstractList, or java.util.AbstractSet are example of template pattern used in Java lib.
 * 
 * >>>>>>>>>>>>>>>>>>Template vs Builder<<<<<<<<<<<<<<<<<
 * Template method is really just a way to define some methods that each subclass must define.
 * while Builder is a creational pattern, it is used to construct a more complex object.
 * 
 * In below example a car is constructed. <<<<<<<<<important.
 * If we were to use the template method pattern we had to create one class for each single combination 
 * of cars or use some nasty inheritance hierarchies. A lot of those methods would also contain duplicate code.
 * 
 * With the build pattern we can instead take different parts and compose those together to a complete car. 
 * Hence we can reuse a engine for every model if needed and we can also customize each part of the car.
 *
 */
public abstract class CarBuilder {
	
	Map<String, String> carParts;
	
	public final Car buildCar() {
		carParts = new HashMap<>();
        addEngine();
        setupBody();
        addWheels();
        return new Car(carParts);
    }
    
    public abstract void addEngine();
    public abstract void setupBody();
    public abstract void addWheels();

}
