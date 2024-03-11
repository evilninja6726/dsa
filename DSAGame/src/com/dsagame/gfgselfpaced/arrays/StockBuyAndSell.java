package com.dsagame.gfgselfpaced.arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        System.out.println(stockBuyAndSell(new int[]{1, 5, 3, 8, 12}));
        System.out.println(stockBuyAndSell(new int[]{5, 4, 3, 2}));
        System.out.println(stockBuyAndSell(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int stockBuyAndSell(int[] arr) {
        int prevPrice = arr[0];
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                res += arr[i - 1] - prevPrice;
                prevPrice = arr[i];
            }
        }
        res += arr[arr.length - 1] - prevPrice;
        return res;
    }
}
