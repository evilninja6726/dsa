package com.dsagame.codingblock.recursion.recursion_1;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 2, 3, 4, 5, 6, 5}, 0));
    }

    public static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return (arr[index] <= arr[index + 1] && isSorted(arr, index + 1));
    }
}
