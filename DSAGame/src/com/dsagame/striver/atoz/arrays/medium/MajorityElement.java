package com.dsagame.striver.atoz.arrays.medium;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    //moore voting algorithm
    public static int majorityElement(int[] arr) {
        int count = 0;
        int candidate = candidate(arr);
        for (int x : arr) {
            if (x == candidate) {
                count++;
            }
        }
        return count > arr.length / 2 ? count : -1;
    }

    public static int candidate(int[] arr) {
        int res = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != res) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                res = arr[i];
            }
        }
        return res;
    }
}
