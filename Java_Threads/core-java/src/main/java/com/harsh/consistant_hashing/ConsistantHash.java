package com.harsh.consistant_hashing;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistantHash<T> {
	
	private final int noOfReplicas;
	private final HashFunction hashFunc;
	private final SortedMap<Integer, T> circle = new TreeMap<>();
	
	public ConsistantHash(HashFunction hashFunc, int noOfReplicas, Collection<T> nodes) {
		this.hashFunc = hashFunc;
		this.noOfReplicas = noOfReplicas;
		
		for(T t : nodes) {
			add(t);
		}
		
	}
	
	public void add(T node) {
		for(int i = 0; i < noOfReplicas; i++) {
			circle.put(hashFunc.hash(node.toString()+i), node);
		}
	}
	
	public void remove(T node) {
		for(int i = 0; i < noOfReplicas; i++) {
			circle.remove(hashFunc.hash(node.toString()+i));
		}
	}
	
	/**
	 * returns the node on which this object wd be stored.
	 * @param key
	 * @return
	 */
	public T getNode(Object key) {
		if(key == null || circle.isEmpty())
			return null;
		
		int hash = hashFunc.hash((String) key);
		
		if(!circle.containsKey(hash)) {
			SortedMap<Integer, T> tailMap = circle.tailMap(hash);
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		} 
		
		return circle.get(hash);
		
	}

}
