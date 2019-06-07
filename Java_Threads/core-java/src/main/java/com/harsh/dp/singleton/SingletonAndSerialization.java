package com.harsh.dp.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * To overcome this issue, we have to implement method readResolve() in our
 * EagerSingleton class, and return the original instance from there.
 * 
 * // implement readResolve method
 * // just put this method in class, no need to override it.
    protected Object readResolve() {
        return instance;
    }
 *
 */
public class SingletonAndSerialization {
	
	public static void main(String[] args) {
		EagerSingleton inst1 = EagerSingleton.getInstance();
		
		try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
			out.writeObject(inst1);
			System.out.println("instance1: " + inst1.hashCode());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(ObjectInput inp = new ObjectInputStream(new FileInputStream("file.txt"))) {
			EagerSingleton inst2 = (EagerSingleton) inp.readObject();
			System.out.println("instance2: " + inst2.hashCode());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//print statement above will print different hash-codes for inst1 and inst2.

}
