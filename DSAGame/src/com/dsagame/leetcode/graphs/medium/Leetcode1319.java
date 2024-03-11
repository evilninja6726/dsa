package com.dsagame.leetcode.graphs.medium;

import com.dsagame.pepcoding.graphs.Edges;

import java.util.ArrayList;

public class Leetcode1319 {
    public static void main(String[] args) {
        int n = 7; // Number of nodes
        int[][] edges = {{0, 1}, {2, 3}, {4, 5}, {5, 6}, {4, 6}};
        System.out.println(makeConnected(n, edges));
    }

    public static void helper(ArrayList<Edges>[] graph, int start, boolean[] isVisited) {
        isVisited[start] = true;
        for (Edges edges : graph[start]) {
            if (!isVisited[edges.d]) {
                helper(graph, edges.d, isVisited);
            }
        }
    }

    public static ArrayList<Edges>[] convertToAdjList(int n, int[][] graph) {
        ArrayList<Edges>[] res = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] arr : graph) {
            res[arr[0]].add(new Edges(arr[0], arr[1], -1));
            res[arr[1]].add(new Edges(arr[1], arr[0], -1));
        }
        return res;
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int res = 0;
        ArrayList<Edges>[] graph = convertToAdjList(n, connections);
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                res++;
                helper(graph, i, isVisited);
            }
        }
        return res - 1;
    }
}
