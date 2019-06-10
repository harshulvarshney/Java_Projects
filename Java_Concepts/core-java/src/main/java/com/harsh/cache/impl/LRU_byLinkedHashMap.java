package com.harsh.cache.impl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author harshul.varshney
 * methods required:
 * get(key)
 * put(key, value)
 * 
 */
public class LRU_byLinkedHashMap {
	
	private int limit;
	private final Map<Integer, String> cache;
	
	public LRU_byLinkedHashMap(int size) {
		this.cache = new LinkedHashMap<Integer, String>(size, .75f, true) {
			/**
			 * removeEldestEntry always gets checked after an element was inserted.
			 * If removeEldestEntry returns false then no items will ever be removed from the map 
			 * and it will essentially behave like a normal Map.
			 */
			@Override
			public boolean removeEldestEntry(Map.Entry<Integer,String> eldest) {
		        return size() > limit;
		    }
		};
		this.limit = size;
	}
	
	
	
	public String get(Integer key) {
		return cache.get(key);
	}
	
	public void put(Integer key, String value) {
		cache.put(key, value);
	}

}
