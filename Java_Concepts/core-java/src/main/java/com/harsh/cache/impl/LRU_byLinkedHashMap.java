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
 * LinkedHashMap provides a special constructor which enables us to specify,
 * among custom load factor (LF) and initial capacity, a different ordering mechanism/strategy called access-order.
 *
 * This mechanism ensures that the order of iteration of elements is the order in which the elements were last accessed,
 * from least-recently accessed to most-recently accessed.
 *
 * And so, building a Least Recently Used (LRU) cache is quite easy and practical with this kind of map.
 * A successful put or get operation results in an access for the entry:
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
