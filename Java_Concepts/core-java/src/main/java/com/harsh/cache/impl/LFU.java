package com.harsh.cache.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LFU {

    private final Integer CAP;
    private final Map<String, Node> map;
    private Node head;
    private Node tail;
    //private final SortedMap<Integer, Node> freqMap;

    public LFU(int size) {
        this.CAP = size;
        head = new Node(null, null, 0);
        tail = new Node(null, null, 0);
        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
        //freqMap = new TreeMap<>();
    }

    public synchronized void add(String key, String val) {
        if(map.containsKey(key)) {
            Node existing = map.get(key);
            existing.val = val;
            existing.freq = existing.freq + 1;
            remove(existing);
            addNodeInQueue(existing);
        }
        else {
            if(map.size() == CAP) {
                remove(tail.prev);
            }
            Node newEntry = new Node(key, val, 1);
            map.put(key, newEntry);
            addNodeInQueue(newEntry);
        }
    }

    public synchronized String get(String key) {
        if(!map.containsKey(key))
            return null;

        Node existing = map.get(key);
        existing.freq = existing.freq + 1;
        remove(existing);
        addNodeInQueue(existing);
        return existing.val;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // this is main diff between LRU and LFU
    // here we are adding the node as per it's frequency (and not adding it to head like LFU)
    private void addNodeInQueue(Node node) {
        Node temp = head;
        while(temp != tail) {
            if(temp.freq > node.freq) {
                temp = temp.next;
            }
            else
                break;
        }

        node.prev = temp.prev;
        temp.prev.next = node;
        temp.prev = node;
        node.next = temp;
    }
}

class Node {

    String key;
    String val;
    Integer freq;
    Node next;
    Node prev;

    public Node(String k, String v, int f) {
        this.key = k;
        this.val = v;
        this.freq = f;
    }

}
