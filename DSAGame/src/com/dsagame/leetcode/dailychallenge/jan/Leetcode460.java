package com.dsagame.leetcode.dailychallenge.jan;

import java.util.HashMap;

public class Leetcode460 {
    public static void main(String[] args) {
//        LFUCache lfu = new LFUCache(2);
//        lfu.put(3, 1);   // cache=[1,_], cnt(1)=1
//        lfu.put(2, 1);
//        lfu.put(2, 2);
//        lfu.put(4, 4);// cache=[2,1], cnt(2)=1, cnt(1)=1
//        System.out.println(lfu.get(2));   // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
//        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//        // cache=[3,1], cnt(3)=1, cnt(1)=2
//        System.out.println(lfu.get(2));      // return -1 (not found)
//        System.out.println(lfu.get(3));      // return 3
//        // cache=[3,1], cnt(3)=2, cnt(1)=2
//        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//        // cache=[4,3], cnt(4)=1, cnt(3)=2
//        System.out.println(lfu.get(1));   // return -1 (not found)
//        System.out.println(lfu.get(3));     // return 3
//        // cache=[3,4], cnt(4)=1, cnt(3)=3
//        System.out.println(lfu.get(4));   // return 4
//        // cache=[4,3], cnt(4)=2, cnt(3)=3


        LFUCache lfu = new LFUCache(3);
        lfu.put(2, 2);   // cache=[1,_], cnt(1)=1
        lfu.put(1, 1);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(2);
        lfu.get(1);
        lfu.get(2);
        // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);
        lfu.put(4, 4);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
//        lfu.get(2);      // return -1 (not found)
//        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
//        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        // return -1 (not found)
        lfu.get(3);
        lfu.get(2);
        lfu.get(1);// return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
    }


}

class LFUCache {
    HashMap<Integer, LFUNode> keyNodeMap;
    HashMap<Integer, DoublyLinkedList> frequencyListMap;
    int size;
    int capacity;
    int leastFrequency;

    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.leastFrequency = 1;
        this.keyNodeMap = new HashMap<>();
        this.frequencyListMap = new HashMap<>();
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            LFUNode node = keyNodeMap.get(key);
            updateNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyNodeMap.containsKey(key)) {
            LFUNode node = keyNodeMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            LFUNode newNode = new LFUNode(key, value);
            if (size == capacity) {
                DoublyLinkedList frequencyList = frequencyListMap.get(leastFrequency);
                keyNodeMap.remove(frequencyList.tail.prev.key);
                frequencyList.removeNode(frequencyList.tail.prev);
                size--;
            }
            size++;
            leastFrequency = 1;
            DoublyLinkedList newList = frequencyListMap.getOrDefault(1, new DoublyLinkedList());
            newList.addNode(newNode);
            keyNodeMap.put(key, newNode);
            frequencyListMap.put(1, newList);
        }
    }

    public void updateNode(LFUNode node) {
        DoublyLinkedList frequencyList = frequencyListMap.get(node.frequency);
        frequencyList.removeNode(node);
        if (node.frequency == leastFrequency && frequencyList.size == 0) {
            leastFrequency++;
        }
        DoublyLinkedList nextList = frequencyListMap.getOrDefault(++node.frequency, new DoublyLinkedList());
        nextList.addNode(node);
        frequencyListMap.put(node.frequency, nextList);
    }

}

class DoublyLinkedList {
    LFUNode head;
    LFUNode tail;
    int size;

    public DoublyLinkedList() {
        this.head = new LFUNode(-1, -1);
        this.tail = new LFUNode(-1, -1);
        this.head.next = tail;
        this.head.prev = null;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void addNode(LFUNode node) {
        size++;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(LFUNode node) {
        size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


class LFUNode {
    int key;
    int value;
    int frequency;
    LFUNode next;
    LFUNode prev;

    public LFUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
