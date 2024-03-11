package com.dsagame.codingblock.recursion.recursion_1;

public class LastOccurrence {
    public static void main(String[] args) {
        System.out.println(lastOccurrence(new int[]{1, 2, 3, 3, 4, 2, 3, 5, 2, 2, 45, 6}, 11, 11));
    }

    public static int lastOccurrence(int[] arr, int i, int x) {
        if (i == 0 && arr[i] == x) {
            return i;
        } else if (i == 0) {
            return -1;
        }
        if (arr[i] == x) {
            return i;
        } else {
            return lastOccurrence(arr, i - 1, x);
        }
    }
}
