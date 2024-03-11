package com.dsagame.leetcode.contest.biweekly94;

public class Leetcode6295 {
    public static void main(String[] args) {
//        System.out.println(minimizeSet(2, 7, 1, 3));
//        System.out.println(minimizeSet(3, 5, 2, 1));
//        System.out.println(minimizeSet(2, 4, 8, 2));
        System.out.println(minimizeSet(9, 4, 8, 3));
    }

    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int[] arr1 = new int[uniqueCnt1];
        int[] arr2 = new int[uniqueCnt2];
        int num = 1;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (divisor1 < divisor2) {
                if (num % divisor1 != 0) {
                    arr1[i++] = num++;
                } else if (num % divisor2 != 0) {
                    arr2[j++] = num++;
                } else {
                    num++;
                }
            } else {
                if (num % divisor2 != 0) {
                    arr2[j++] = num++;
                } else if (num % divisor1 != 0) {
                    arr2[i++] = num++;
                } else {
                    num++;
                }
            }
        }
        while (i < arr1.length) {
            if (num % divisor1 != 0) {
                arr1[i++] = num++;
            } else {
                num++;
            }
        }
        while (j < arr2.length) {
            if (num % divisor2 != 0) {
                arr2[j++] = num++;
            } else {
                num++;
            }
        }
        return Math.max(arr1[uniqueCnt1 - 1], arr2[uniqueCnt2 - 1]);
    }
}
