package com.dsagame.leetcode.graphs.medium;

import com.dsagame.pepcoding.graphs.Edges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode797 {
    public static void main(String[] args) {
        //graph = [[1,2],[3],[3],[]]
        ArrayList<Integer>[] graph = new ArrayList[]{
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>()
        };
        // Get the number of nodes
        int n = graph.length;
        // Create a 2D array
        int[][] adjacencyMatrix = new int[n][n];
        // Populate the array based on the given graph
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adjacencyMatrix[i][neighbor] = 1;
            }
        }
        for (int[] arr : adjacencyMatrix) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(allPathsSourceTarget(adjacencyMatrix));
    }

    public static void collectPath(ArrayList<Edges>[] graph, int s, int d, boolean[] isVisited,
                                   List<Integer> pathSoFar, List<List<Integer>> res) {
        if (s == d) {
            res.add(new ArrayList<>(pathSoFar));
            return;
        }
        isVisited[s] = true;
        for (Edges edges : graph[s]) {
            if (!isVisited[edges.d]) {
                pathSoFar.add(edges.d);
                collectPath(graph, edges.d, d, isVisited, pathSoFar, res);
                pathSoFar.remove(pathSoFar.size() - 1);
            }
        }
        isVisited[s] = false;
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Edges>[] adjListGraph = new ArrayList[graph.length];
        for (int i = 0; i < graph.length; i++) {
            adjListGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjListGraph[i].add(new Edges(i, graph[i][j], -1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> individualList = new ArrayList<>();
        individualList.add(0);
        collectPath(adjListGraph, 0, graph.length - 1, new boolean[graph.length], individualList, res);
        return res;
    }
}
