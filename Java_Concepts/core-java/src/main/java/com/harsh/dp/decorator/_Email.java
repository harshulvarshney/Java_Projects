package com.harsh.dp.decorator;

/**
 * The Decorator is known as a structural pattern,
 * as it's used to form large object structures across many disparate objects.
 * 
 * To enhance an Object's functionality, we could update it's class but then Open/Closed principal is violated.
 * To extend an object's functionality, we can also create subclasses but it is not the best option sometimes.
 * 
 * The Decorator pattern should be used when:
 * 		Object responsibilities and behaviours should be dynamically modifiable
 * 		Concrete implementations should be decoupled from responsibilities and behaviours
 * 
 * Disadvantage:
 * The Design Patterns book does point out a couple of disadvantages with this pattern. 
 * Decorators can lead to a system with a lot of smaller objects that will look similar to a developer 
 * and introduce a maintenance headache. Also, the Decorator and it's enclosed components are not identical, 
 * so tests for object type (instanceof) will fail.
 * 
 * @author harshul.varshney
 */
public interface _Email {
	public String getContent();
}
