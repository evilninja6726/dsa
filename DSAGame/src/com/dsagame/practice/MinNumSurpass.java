package com.dsagame.practice;

public class MinNumSurpass {
    public static void main(String[] args) {
        System.out.println(minNum(3, 5, 1));
        System.out.println(minNum(3, 5, 5));
        System.out.println(minNum(4, 5, 1));
    }

    public static int minNum(int samDaily, int kellyDaily, int difference) {
        if (samDaily >= kellyDaily) {
            return -1;
        }
        int res = 1;
        int sam = samDaily + difference;
        int kelly = kellyDaily;
        while (kelly <= sam) {
            sam += samDaily;
            kelly += kellyDaily;
            res++;
        }
        return res;
    }
}
