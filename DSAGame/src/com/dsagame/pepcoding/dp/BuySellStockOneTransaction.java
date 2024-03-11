package com.dsagame.pepcoding.dp;

public class BuySellStockOneTransaction {
    public static void main(String[] args) {
        System.out.println(buySell(new int[]{4, 6, 7, 19, 4, 1, 6, 18, 4}));
    }

    public static int buySell(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int minprices = prices[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprices) {
                minprices = prices[i];
            } else {
                res = Math.max(res, prices[i] - minprices);
            }
        }
        return res;
    }
}
