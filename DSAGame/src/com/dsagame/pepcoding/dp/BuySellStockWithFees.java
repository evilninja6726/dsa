package com.dsagame.pepcoding.dp;

public class BuySellStockWithFees {
    public static void main(String[] args) {
        /*Example 1:
        Input: prices = [1,3,2,8,4,9], fee = 2
        Output: 8
        Explanation: The maximum profit can be achieved by:
        - Buying at prices[0] = 1
                - Selling at prices[3] = 8
                - Buying at prices[4] = 4
                - Selling at prices[5] = 9
        The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

        Example 2:
        Input: prices = [1,3,7,5,10,3], fee = 3
        Output: 6
        */

        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));

        System.out.println(maxProfitEff(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfitEff(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[2][prices.length + 1];
        dp[0][1] = (-prices[0]);
        for (int j = 2; j < dp[0].length; j++) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j - 1] - prices[j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], prices[j - 1] + dp[i - 1][j - 1] - fee);
                }
            }
        }
        return dp[1][prices.length];
    }

    public static int maxProfitEff(int[] prices, int fee) {
        int loan = (-prices[0]);
        int savings = 0;
        for (int i = 1; i < prices.length; i++) {
            int prevLoan = loan;
            loan = Math.max(loan, savings - prices[i]);
            savings = Math.max(savings, prices[i] + prevLoan - fee);
        }
        return savings;
    }
}
