package com.dsagame.pepcoding.dp;

public class BuySellStockInfiniteTransaction {
    public static void main(String[] args) {
        System.out.println(profit(new int[]{11, 6, 7, 19, 4, 1, 6, 18, 4, 100}));
    }

    public static int profit(int[] prices) {
        int res = 0;
        int curr = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] >= prices[i]) {
                min = prices[i];
                res += curr;
                curr = 0;
            } else {
                curr = Math.max(curr, prices[i] - min);
            }
        }
        return res + curr;
    }
}
