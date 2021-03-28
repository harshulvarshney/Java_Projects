package com.harsh.cache.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * if we dont want to use LinkedHashMap provided in java, then we can use the seme concept to build a custom LRU cache:
 *
 *      Use a doubly linked list for capacity
 *      Use a HashMap for O(1) get operation
 *      There will be only 2 internal operations: delete and insertAtStart
 *      create a LinkedList head and tail to facilitate both internal operations
 */
public class LRU_custom {

    private final Map<Integer, Node> map;
    private final int capacity;
    private int count;
    private Node head;
    private Node tail;

    private static class Node {

        public Node(int k, int v) {
            this.value = v;
            this.next = null;
            this.prev = null;
        }

        public int key;
        public int value;
        public Node next;
        public Node prev;
    }

    public LRU_custom(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.count = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void delete(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAtStart(Node node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node != null) {
            delete(node);
            insertAtStart(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            node.value = value;
            delete(node);
            insertAtStart(node);
        }
        else {
            Node newNode = new Node(key, value);
            if(count < capacity) {
                count++;
                insertAtStart(newNode);
            }
            else {
                Node lastNode = tail.prev;
                delete(lastNode);
                map.remove(lastNode.key);
                map.put(key, newNode);
                insertAtStart(newNode);
            }
        }
    }

}
