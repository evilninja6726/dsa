package com.dsagame.striver.atoz.arrays.medium;

public class SortColor {
    public static void main(String[] args) {

    }

    public static void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int num : nums) {
            freq[num]++;
        }
        int k = 0;
        for (int i = 0; i < 3; i++) {
            while (freq[i]-- > 0) {
                nums[k++] = i;
            }
        }
    }
}
