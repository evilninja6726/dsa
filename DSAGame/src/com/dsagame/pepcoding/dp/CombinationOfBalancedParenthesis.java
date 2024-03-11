package com.dsagame.pepcoding.dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfBalancedParenthesis {


    public static void main(String[] args) {
        System.out.println(count(4));
        System.out.println(generateParenthesis(4).toString());
    }

    public static int count(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (double) ((4 * i) + 2) / (i + 2);
        }
        return res;
    }

    public static List<String> generateParenthesis(int n) {
        List<String>[] dp = new ArrayList[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");
        dp[1].add("()");
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (String list1 : dp[i - j - 1]) {
                    for (String list2 : dp[j]) {
                        dp[i].add("(" + list1 + ")" + list2);
                    }
                }
            }
        }
        return dp[n];
    }
}
