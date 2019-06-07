package com.harsh.cache.impl;

public class LRUTest {
	
	public static void main(String[] args) {
		LRU_byLinkedHashMap cache = new LRU_byLinkedHashMap(3);
		cache.put(1, "harsh");
		cache.put(2, "harsh");
		cache.put(3, "harsh");
		System.out.println("get 2: " + cache.get(2));
		cache.put(4, "harsh");
		System.out.println("get 1: " + cache.get(1));
		cache.put(1, "harsh");
		System.out.println("get 1: " + cache.get(1));
		System.out.println("get 3: " + cache.get(3));
		cache.put(5, "harsh");
	}

}
