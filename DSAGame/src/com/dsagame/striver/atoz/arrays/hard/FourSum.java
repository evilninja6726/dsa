package com.dsagame.striver.atoz.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                res.addAll(threeSum(nums, target - nums[i], i + 1));
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] arr, int k, int i) {
        List<List<Integer>> res = new ArrayList<>();
        for (int j = i; j < arr.length - 2; j++) {
            if (j == i || arr[j] != arr[j - 1]) {
                int x = j + 1;
                int y = arr.length - 1;
                while (x < y) {
                    if (arr[j] + arr[x] + arr[y] == k) {
                        res.add(Arrays.asList(arr[i - 1], arr[j], arr[x], arr[y]));
                        while (x < y && arr[x] == arr[x + 1]) {
                            x++;
                        }
                        while (x < y && arr[y] == arr[y - 1]) {
                            y--;
                        }
                        x++;
                        y--;
                    } else {
                        if (arr[j] + arr[x] + arr[y] < k) {
                            x++;
                        } else {
                            y--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
