package com.dsagame.gfgselfpaced.arrays;

public class FrequencyOfSorted {
    public static void main(String[] args) {
        frequency(new int[]{10, 10, 10, 30, 40, 40, 50});
        frequency(new int[]{10});
    }

    public static void frequency(int[] arr) {
        int currFreq = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currFreq++;
            } else {
                System.out.println(arr[i - 1] + "-" + currFreq);
                currFreq = 1;
            }
        }
        System.out.println(arr[arr.length - 1] + "-" + currFreq);
    }
}
