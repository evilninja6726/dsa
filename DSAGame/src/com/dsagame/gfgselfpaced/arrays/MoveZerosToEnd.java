package com.dsagame.gfgselfpaced.arrays;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        moveZerosToEnd(new int[]{3, 31, 3, 5, 7, 0, 45, 3, 0, 0, 0, 0, 6, 0});
    }

    public static void moveZerosToEnd(int[] arr) {
        int countOfNonZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[countOfNonZero];
                arr[countOfNonZero] = temp;
                countOfNonZero++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
