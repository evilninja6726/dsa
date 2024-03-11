package com.dsagame.pepcoding.dp;

public class ArrangeBuildings {
    public static void main(String[] args) {
        System.out.println(arrange(6));
        System.out.println(arrangeEff(6));
        System.out.println(arrange(7));
        System.out.println(arrangeEff(7));
        System.out.println(arrange(8));
        System.out.println(arrangeEff(8));
        System.out.println(arrange(9));
        System.out.println(arrangeEff(9));
    }

    public static int arrange(int n) {
        int[][] dp = new int[2][n + 1];
        for (int j = 0; j < n + 1; j++) {
            for (int i = 0; i < 2; i++) {
                if (j == 0 || j == 1) {
                    dp[i][j] = j;
                } else if (i == 0) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
            }
        }
        return (dp[0][n] + dp[1][n]) * (dp[0][n] + dp[1][n]);
    }

    public static int arrangeEff(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 2;
        }
        int endWithB = 1;
        int endWithS = 1;
        for (int i = 2; i <= n; i++) {
            int temp = endWithB;
            endWithB = endWithS;
            endWithS += temp;

        }
        return (endWithB + endWithS) * (endWithB + endWithS);
    }
}
