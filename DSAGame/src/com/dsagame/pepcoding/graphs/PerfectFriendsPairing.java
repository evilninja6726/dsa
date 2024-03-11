package com.dsagame.pepcoding.graphs;

import java.util.ArrayList;

public class PerfectFriendsPairing {
    public static void main(String[] args) {
        int n = 7; // Number of nodes
        int[][] edges = {{0, 1, 10}, {2, 3, 10}, {4, 5, 10}, {5, 6, 10}, {4, 6, 10}};
        System.out.println(pairingWays(n, edges));
    }

    public static int pairingWays(int n, int[][] graph) {
        int res = 0;
        boolean[] isVisited = new boolean[n];
        ArrayList<Edges>[] adjList = arrayToList(n, graph);
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> group = new ArrayList<>();
            if (!isVisited[i]) {
                helper(adjList, i, isVisited, group);
            }
            groups.add(new ArrayList<>(group));
        }
        for (int i = 0; i < groups.size(); i++) {
            for (int j = i + 1; j < groups.size(); j++) {
                res += (groups.get(i).size() * groups.get(j).size());
            }
        }
        return res;
    }

    public static void helper(ArrayList<Edges>[] graph, int start, boolean[] isVisited, ArrayList<Integer> group) {
        isVisited[start] = true;
        group.add(start);
        for (Edges edges : graph[start]) {
            if (!isVisited[edges.d]) {
                helper(graph, edges.d, isVisited, group);
            }
        }
    }

    public static ArrayList<Edges>[] arrayToList(int n, int[][] graph) {
        ArrayList<Edges>[] res = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] arr : graph) {
            res[arr[0]].add(new Edges(arr[0], arr[1], arr[2]));
            res[arr[1]].add(new Edges(arr[1], arr[0], arr[2]));
        }
        return res;
    }
}
