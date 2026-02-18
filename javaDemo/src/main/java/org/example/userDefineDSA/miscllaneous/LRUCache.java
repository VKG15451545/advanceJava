package org.example.userDefineDSA.miscllaneous;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <K,V>{

    private class Node{
        K key;
        V value;
        long expiryTime;
        Node prev,next;
        public Node(K key,V value,long expiryTime){
            this.key = key;
            this.value = value;
            this.expiryTime = expiryTime;
        }
        public boolean isExpired(){
            return System.currentTimeMillis()> expiryTime;
        }
    }

    private Map<K,Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(null,null,100000000);
        this.tail = new Node(null,null,100000000);
        head.next = tail;
        tail.prev = head;
    }

    public void insert(K key,V value,long ttl){
        Node existingNode = map.get(key);
        if(existingNode != null){
            existingNode.value = value;
            existingNode.expiryTime = ttl + System.currentTimeMillis();
            moveNodeToHead(existingNode);
            map.put(key,existingNode);
        }else{
            if(map.size()==capacity){
                Node lru = tail.prev;
                remove(lru);
            }
            Node newNode = new Node(key,value,ttl);
            moveNodeToHead(newNode);
        }
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveNodeToHead(Node node){
        remove(node);
        insertAtHead(node);
    }
    public void insertAtHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

}
