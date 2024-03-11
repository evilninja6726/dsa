package com.dsagame.gfgselfpaced.arrays;

public class SecondLargest {
    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{1,2,2,3,4,3,2,5,4}));
        System.out.println(secondLargest(new int[]{2,1,1,1,}));

    }

    public static int secondLargest(int[] arr){
        if (arr.length<=1){
            return -1;
        }
        int max=arr[0];
        int res=-1;
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                res=max;
                max=arr[i];
            }else if (arr[i]<max&&arr[i]>res){
                res=arr[i];
            }
        }
        return res;
    }
}
