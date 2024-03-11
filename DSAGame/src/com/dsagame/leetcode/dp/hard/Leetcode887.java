package com.dsagame.leetcode.dp.hard;

public class Leetcode887 {
    public static void main(String[] args) {
        System.out.println(superEggDrop(2, 6));
        System.out.println(superEggDrop(3, 14));
    }

//    public static int superEggDrop(int k, int n) {
//        //  return helper(k,n);
//        int[][] dp = new int[k + 1][n + 1];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, -1);
//        }
//        //return helper(k, n, dp);
//        return helperBS(k, n, dp);
//    }

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int eggs = 0; eggs < dp.length; eggs++) {
            for (int floors = 0; floors < dp[eggs].length; floors++) {
                if (eggs == 0) {
                    dp[eggs][floors] = 0;
                } else if (floors == 0 || floors == 1 || eggs == 1) {
                    dp[eggs][floors] = floors;
                } else {
                    int low = 1;
                    int high = floors;
                    int res = Integer.MAX_VALUE;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        int survive = dp[eggs][floors - mid];
                        int broke = dp[eggs - 1][mid - 1];
                        int max = 1 + Math.max(survive, broke);
                        res = Math.min(res, max);
                        if (survive <= broke) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    dp[eggs][floors] = res;
                }
            }
        }
        return dp[k][n];
    }

    public static int helper(int k, int n) {    //Recursive
        if (n == 0 || n == 1) {
            return n;
        } else if (k == 1) {
            return n;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int survive = helper(k, n - i);
            int broke = helper(k - 1, i - 1);
            int max = 1 + Math.max(survive, broke);
            res = Math.min(res, max);
        }
        return res;
    }

    public static int helper(int k, int n, int[][] dp) {
        if (n == 0 || n == 1) {
            return n;
        } else if (k == 1) {
            return n;
        }
        if (dp[k][n] != -1) {
            return dp[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int survive = helper(k, n - i, dp);
            int broke = helper(k - 1, i - 1, dp);
            int max = 1 + Math.max(survive, broke);
            res = Math.min(res, max);
        }
        dp[k][n] = res;
        return dp[k][n];
    }

    public static int helperBS(int k, int n, int[][] dp) {
        if (n == 0 || n == 1 || k == 1) {
            return n;
        }
        if (dp[k][n] != -1) {
            return dp[k][n];
        }
        int low = 1;
        int high = n;
        int res = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int survive = helperBS(k, n - mid, dp);
            int broke = helperBS(k - 1, mid - 1, dp);
            int max = 1 + Math.max(survive, broke);
            res = Math.min(res, max);
            if (max == survive + 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        dp[k][n] = res;
        return dp[k][n];
    }


}
