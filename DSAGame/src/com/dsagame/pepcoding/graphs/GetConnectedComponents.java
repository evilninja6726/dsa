package com.dsagame.pepcoding.graphs;

import java.util.ArrayList;

public class GetConnectedComponents {
    public static void main(String[] args) {
        int n = 7; // Number of nodes
        int[][] edges = {{0, 1, 10}, {2, 3, 10}, {4, 5, 10}, {5, 6, 10}, {4, 6, 10}};
        System.out.println(getConnectedComponents(n, edges));
    }

    public static ArrayList<ArrayList<Integer>> getConnectedComponents(int n, int[][] graph) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Edges>[] adjList = arrayToList(n, graph);
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                helper(adjList, i, isVisited, component);
                res.add(new ArrayList<>(component));
            }
        }
        return res;
    }

    public static void helper(ArrayList<Edges>[] graph, int start, boolean[] isVisited, ArrayList<Integer> component) {
        isVisited[start] = true;
        component.add(start);
        for (Edges edges : graph[start]) {
            if (!isVisited[edges.d]) {
                helper(graph, edges.d, isVisited, component);
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
