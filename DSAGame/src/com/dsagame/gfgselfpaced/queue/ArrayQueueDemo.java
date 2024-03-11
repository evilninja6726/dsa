package com.dsagame.gfgselfpaced.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(6);
        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.isFull());
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.size());
        System.out.println("Front" + arrayQueue.getFront());
        System.out.println("Rear" + arrayQueue.getRear());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.getFront());
        System.out.println(arrayQueue.getRear());
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(7);
        arrayQueue.enqueue(8);
        arrayQueue.enqueue(9);
        System.out.println("Front" + arrayQueue.getFront());
        System.out.println("Rear" + arrayQueue.getRear());
        System.out.println(arrayQueue.arr[arrayQueue.getFront()]);
        System.out.println(arrayQueue.arr[arrayQueue.getRear()]);

    }


}