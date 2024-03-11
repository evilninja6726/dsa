package com.dsagame.gfgselfpaced.arrays;

public class LargestElement {
    public static void main(String[] args) {

    }

    public static int largest(int[] arr){
        int res=arr[0];
        for (int i=1;i<arr.length;i++){
            res=Math.max(res,arr[i]);
        }
        return res;
    }
}
