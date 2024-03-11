package com.dsagame.leetcode.dp.medium;

public class Leetcode1143 {
    public static void main(String[] args) {
        /*
        * Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 */

        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));


        //"ezupkr"
        //"ubmrapg"

        System.out.println(longestCommonSubsequence("ezupkr",
                "ubmrapg"));

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text2.length() + 1][text1.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if (i != dp.length - 1 && j != dp[i].length - 1) {
                    if (text1.charAt(j) == text2.charAt(i)) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }

//    public static int longestCommonSubsequenceSpaceOptimized(String text1, String text2) {    // not complete
//        int[] dp = new int[text1.length() + 1];
//        for (int i = text2.length() - 1; i >= 0; i--) {
//            int right = 0;
//            int diagonal = 0;
//            for (int j = text1.length() - 1; j >= 0; j--) {
//                if (text1.charAt(j) == text2.charAt(i)) {
//                    dp[j] = diagonal + 1;
//                } else {
//                    dp[j] = Math.max(dp[j], right);
//                    right = dp[j];
//                }
//            }
//        }
//        return dp[0];
//    }
}
