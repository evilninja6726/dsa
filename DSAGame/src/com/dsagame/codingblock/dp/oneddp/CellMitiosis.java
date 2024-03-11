package com.dsagame.codingblock.dp.oneddp;

public class CellMitiosis {
    public static void main(String[] args) {
        System.out.println(cellTab(7, 1, 1, 1));
    }

    // 2i=x i+1=y i-1=z
    public static int cellTab(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(x + dp[i / 2], y + dp[i - 1]);
            } else {
                dp[i] = Math.min(y + dp[i - 1], z + x + dp[(i + 1) / 2]);
            }
        }
        return dp[n];
    }
}
