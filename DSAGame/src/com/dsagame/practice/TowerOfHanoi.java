package com.dsagame.practice;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(3, 'a', 'b', 'c');
    }

    public static void towerOfHanoi(int n, char a, char b, char c) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, a, c, b);
        System.out.println("Move disc " + n + " from " + a + " to " + b);
        towerOfHanoi(n - 1, c, b, a);
    }
}
