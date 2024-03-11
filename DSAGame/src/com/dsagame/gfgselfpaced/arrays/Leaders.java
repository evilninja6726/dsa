package com.dsagame.gfgselfpaced.arrays;

public class Leaders {
    public static void main(String[] args) {
        leaders(new int[]{2, 4, 5, 7, 4, 3, 2, 5, 7, 8, 5, 3});
        leaders(new int[]{7, 10, 4, 3, 6, 5, 2});
    }

    public static void leaders(int[] arr) {
        int max = arr[arr.length - 1];
        System.out.print(max + " ");
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                System.out.print(arr[i] + " ");
                max = arr[i];
            }
        }
        System.out.println();
    }
}
