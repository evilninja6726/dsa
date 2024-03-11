package com.dsagame.codingblock.dp.quickstart;

public class ReduceNTo1 {
    public static void main(String[] args) {
        System.out.println(reduceRec(100));
        System.out.println(reduceDPMem(100, new int[100 + 1]));
        System.out.println(reduceDpTab(100));
    }

    public static int reduceRec(int n) {
        if (n == 1) {
            return 0;
        }
        int reduceOne = reduceRec(n - 1);
        int divideTwo = Integer.MAX_VALUE;
        int divideThree = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            divideTwo = reduceRec(n / 2);
        }
        if (n % 3 == 0) {
            divideThree = reduceRec(n / 3);
        }
        return 1 + Math.min(reduceOne, Math.min(divideTwo, divideThree));
    }

    public static int reduceDPMem(int n, int[] dp) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int reduceOne = reduceDPMem(n - 1, dp);
        int divideTwo = Integer.MAX_VALUE;
        int divideThree = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            divideTwo = reduceRec(n / 2);
        }
        if (n % 3 == 0) {
            divideThree = reduceRec(n / 3);
        }
        dp[n] = 1 + Math.min(reduceOne, Math.min(divideTwo, divideThree));
        return dp[n];
    }

    public static int reduceDpTab(int n) {
        int[] dp = new int[10000001];
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                dp[i] = 1 + Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3]));
            } else if (i % 2 == 0) {
                dp[i] = 1 + Math.min(dp[i - 1], dp[i / 2]);
            } else if (i % 3 == 0) {
                dp[i] = 1 + Math.min(dp[i - 1], dp[i / 3]);
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }
        return dp[n];
    }
}
