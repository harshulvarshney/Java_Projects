package com.harsh.dp.strategy;

import java.io.File;
import java.util.ArrayList;

/**
 * Strategy design pattern is based upon open closed design principle, which states that 
 * a design, code (class or method) should remain open for extension but closed for modification.
 * 
 * The Strategy pattern is known as a behavioural pattern - 
 * it's used to manage algorithms, relationships and responsibilities between objects. The behavior
 * of object is changed at runtime.
 * 
 * The Strategy pattern is to be used where you want to choose the algorithm to use at runtime. 
 * A good use of the Strategy pattern would be saving files in different formats, 
 * running various sorting algorithms, or file compression.
 *
 * The Strategy pattern provides a way to define a family of algorithms, 
 * encapsulate each one as an object, and make them interchangeable. 
 * 
 * {@Code Comparator} in java is an example of Strategy. We define compare() method, 
 * now it's up to the classes how they compare themselves.
 * 
 * @author harshul.varshney
 */
public interface CompressionStrategy {
	
	public void compressFiles(ArrayList<File> files);

}
