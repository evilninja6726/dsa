package com.dsagame.pepcoding.dp;

public class BuySellStockTwoTransaction {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
        System.out.println(maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    public static int maxProfit(int[] prices) {
        int[] beforeTransactions = new int[prices.length];
        int[] afterTransactions = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            beforeTransactions[i] = Math.max(beforeTransactions[i - 1], prices[i] - minPrice);
        }
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (maxPrice < prices[i]) {
                maxPrice = prices[i];
            }
            afterTransactions[i] = Math.max(afterTransactions[i + 1], maxPrice - prices[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, beforeTransactions[i] + afterTransactions[i]);
        }
        return res;
    }
}
