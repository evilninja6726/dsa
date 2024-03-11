package com.dsagame.striver.binarysearch;

public class LowerBound {
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{1, 2, 3, 4, 5, 6, 7, 44, 77}, 7));
    }

    public static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        int res = arr.length;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;

            }


        }

        return res;

    }

}
