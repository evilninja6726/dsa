package com.dsagame.leetcode.contest.biweekly97;

public class Leetcode6304 {
    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1, 6, 5}, 5, 6));
        System.out.println(maxCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1));
        System.out.println(maxCount(new int[]{11}, 7, 50));
        System.out.println();
    }

//    public static int maxCount(int[] banned, int n, int maxSum) {
//        int res = 0;
//        int sum = 0;
//        boolean[] isDone = new boolean[10001];
//        return helper(banned, n, maxSum, 0, isDone);
//    }
//
//    public static int helper(int[] banned, int n, int maxSum, int sum, boolean[] isDone) {
//        if (sum >= maxSum) {
//            return 1;
//        }
//        int[] banFrequency = new int[10001];
//        for (int banNum : banned) {
//            banFrequency[banNum]++;
//        }
//        int res = 0;
//        for (int i = 1; i <= n; i++) {
//            if (banFrequency[i] == 0 && !isDone[i]) {
//                isDone[i] = true;
//                sum += i;
//                res += helper(banned, n, maxSum, sum, isDone);
//                isDone[i] = false;
//                sum -= i;
//            }
//        }
//        return res;
//    }


    public static int maxCount(int[] banned, int n, int maxSum) {
        boolean[] isBanned = new boolean[10001];
        for (int x : banned) {
            isBanned[x] = true;
        }
        boolean[] isDone = new boolean[10001];
        int res = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!isDone[i] && !isBanned[i] && sum + i <= maxSum) {
                isDone[i] = true;
                sum += i;
                res++;
            }
        }
        return res;
    }
}
