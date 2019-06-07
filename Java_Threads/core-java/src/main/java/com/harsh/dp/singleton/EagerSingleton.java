package com.harsh.dp.singleton;

import java.io.Serializable;

public class EagerSingleton implements Serializable {
	
	private static final long serialVersionUID = -6474104120497567057L;
	private static volatile EagerSingleton instance = new EagerSingleton();
	 
    // private constructor
    private EagerSingleton() {
//    	if(instance != null)   -- this is to make it reflection safe.
//    		throw new RuntimeException();
    }
 
    public static EagerSingleton getInstance() {
        return instance;
    }
    
    protected Object readResolve() {
    	return instance;
    }
}
