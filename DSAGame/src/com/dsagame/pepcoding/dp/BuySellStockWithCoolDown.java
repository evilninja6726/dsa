package com.dsagame.pepcoding.dp;

public class BuySellStockWithCoolDown {
    public static void main(String[] args) {
        /*Example 1:
        Input: prices = [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]

        Example 2:
        Input: prices = [1]
        Output: 0*/
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfit(new int[1]));
        System.out.println(maxProfit(new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25}));

        System.out.println(maxProfitEff(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfitEff(new int[1]));
        System.out.println(maxProfitEff(new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25}));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length + 1];
        dp[0][1] = (-prices[0]);
        for (int j = 2; j < dp[0].length; j++) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 2][j - 1] - prices[j - 1]);
                } else if (i == 1) {
                    dp[i][j] = Math.max(dp[i][j - 1], prices[j - 1] + dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[1][prices.length];
    }

    public static int maxProfitEff(int[] prices) {
        int loan = (-prices[0]);
        int savings = 0;
        int coolDownProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int prevLoan = loan;
            loan = Math.max(loan, coolDownProfit - prices[i]);
            int prevSavings = savings;
            savings = Math.max(savings, prices[i] + prevLoan);
            coolDownProfit = prevSavings;
        }
        return savings;
    }
}
