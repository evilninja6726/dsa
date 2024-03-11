package com.dsagame.gfgselfpaced.linkedlist;

import java.util.HashMap;

public class LRUCacheDesign {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.get(2);
        cache.get(1);
        cache.set(2, 20);
        cache.get(2);
        cache.set(3, 30);
        cache.set(2, 10);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.set(4, 40);
        cache.get(2);
        cache.get(3);
        cache.set(5, 50);
        cache.get(4);
    }
}

class LRUNode {
    int key;
    int value;
    LRUNode next;
    LRUNode prev;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int size;
    int capacity;
    HashMap<Integer, LRUNode> hashMap;
    LRUNode head;
    LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.hashMap = new HashMap<>();
        this.head = new LRUNode(0, 0);
        this.tail = new LRUNode(0, 0);
        this.head.next = tail;
        this.head.prev = null;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void get(int key) {
        if (hashMap.get(key) != null) {
            LRUNode node = hashMap.get(key);
            int keyValue = node.value;
            System.out.println("The value for key " + key + " is " + keyValue);
            delete(node);
            addToHead(node);
            return;
        }
        System.out.println("The value for key " + key + " is " + (-1));
    }

    public void set(int key, int value) {
        if (hashMap.get(key) != null) {
            LRUNode node = hashMap.get(key);
            node.value = value;
            System.out.println("Found a Hit: " + key + " = " + value);
            delete(node);
            addToHead(node);
        } else {
            LRUNode newNode = new LRUNode(key, value);
            hashMap.put(key, newNode);
            System.out.println("Found a Miss: " + key + " = " + value);
            if (size < capacity) {
                size++;
            } else {
                hashMap.remove(tail.prev.key);
                delete(tail.prev);
            }
            addToHead(newNode);
        }
    }

    public void delete(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(LRUNode node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}
