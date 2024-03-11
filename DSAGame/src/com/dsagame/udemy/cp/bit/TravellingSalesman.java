package com.dsagame.udemy.cp.bit;

import java.util.Arrays;

public class TravellingSalesman {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 2, 0, 0, 5},
                {2, 0, 1, 4, 3},
                {0, 1, 0, 7, 0},
                {0, 4, 7, 0, 6},
                {5, 3, 0, 6, 0}
        };

        int[][] dist = {
                {0, 29, 20, 21},
                {29, 0, 15, 17},
                {20, 15, 0, 28},
                {21, 17, 28, 0}
        };

        int[][] distance = {
                {0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0}
        };
        System.out.println(minCost(dist));
        System.out.println(minCost(distance));
    }

    public static int minCost(int[][] graph) {
        //return helper(graph, graph.length, 0, 1);
        int[][] dp = new int[1 << graph.length][graph.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helperMem(graph, graph.length, 0, 1, dp);
    }

    public static int helper(int[][] graph, int v, int source, int visited) {
        if (visited == (1 << v) - 1) {
            return graph[source][0];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            int mask = 1 << i;
            if ((mask & visited) == 0) {
                res = Math.min(res, graph[source][i] + helper(graph, v, i, visited | mask));
            }
        }
        return res;
    }

    public static int helperMem(int[][] graph, int v, int source, int visited, int[][] dp) {
        if ((1 << v) - 1 == visited) {
            return graph[source][0];
        }
        if (dp[visited][source] != -1) {
            return dp[visited][source];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            int mask = 1 << i;
            if ((mask & visited) == 0) {
                res = Math.min(res, graph[source][i] + helperMem(graph, v, i, visited | mask, dp));
            }
        }
        dp[visited][source] = res;
        return res;
    }
}
