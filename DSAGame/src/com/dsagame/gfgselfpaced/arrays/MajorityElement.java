package com.dsagame.gfgselfpaced.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{8, 7, 6, 8, 6, 6, 6, 6}));
    }

    public static int majorityElement(int[] arr) {
        int res = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int x : arr) {
            if (x == arr[res]) {
                count++;
            }
        }
        return (count > arr.length / 2) ? res : -1;
    }
}
