package com.dsagame.pepcoding.dp;

public class PaintFence {
    public static void main(String[] args) {
        System.out.println(paintFence(8, 3));
        System.out.println(paintFence(8, 3));
    }

    public static int paintFence(int n, int k) {
        if (n == 1) {
            return k;
        }
        int[][] dp = new int[3][n];
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < 3; i++) {
                if (j == 1) {
                    if (i == 0) {
                        dp[i][j] = k;
                    } else if (i == 1) {
                        dp[i][j] = k * (k - 1);
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else if (i == 1) {
                        dp[i][j] = 2 * dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
                    }
                }
            }
        }
        return dp[2][n - 1];
    }

    public static int paintFenceEff(int n, int k) {
        if (n == 1) {
            return 3;
        }
        int same = k;
        int diff = k * (k - 1);
        int total = same + diff;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }
}
