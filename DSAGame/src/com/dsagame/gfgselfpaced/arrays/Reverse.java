package com.dsagame.gfgselfpaced.arrays;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        reverse(new int[]{1, 2, 4, 5, 3, 23, 5, 6});
    }

    public static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
