package com.dsagame.codingblock.dp.quickstart;

public class WineProblem {
    public static void main(String[] args) {
        System.out.println(wineRec(new int[]{2, 3, 5, 1, 4}, 0, 4, 1));
        System.out.println(wineMem(new int[]{2, 3, 5, 1, 4}, 0, 4, 1, new int[5][5]));
        
    }

    public static int wineRec(int[] arr, int i, int j, int year) {
        if (i == j) {
            return year * arr[i];
        }
        int valueUsingFirst = wineRec(arr, i + 1, j, year + 1);
        int valueUsingLast = wineRec(arr, i, j - 1, year + 1);
        return Math.max(valueUsingFirst + (year * arr[i]), valueUsingLast + (year * arr[j]));
    }

    public static int wineMem(int[] arr, int i, int j, int year, int[][] dp) {
        if (i == j) {
            return year * arr[i];
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int valueUsingFirst = wineRec(arr, i + 1, j, year + 1);
        int valueUsingLast = wineRec(arr, i, j - 1, year + 1);
        dp[i][j] = Math.max(valueUsingFirst + (year * arr[i]), valueUsingLast + (year * arr[j]));
        return dp[i][j];
    }


}
