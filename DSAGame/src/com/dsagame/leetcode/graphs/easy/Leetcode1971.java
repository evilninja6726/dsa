package com.dsagame.leetcode.graphs.easy;

import com.dsagame.pepcoding.graphs.Edges;

import java.util.ArrayList;

public class Leetcode1971 {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(3, edges, 0, 2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edges>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        //edges = [[0,1],[0,2],[3,5],[5,4],[4,3]]
        for (int i = 0; i < n; i++) {
            graph[edges[i][0]].add(new Edges(edges[i][0], edges[i][1], -1));
            graph[edges[i][1]].add(new Edges(edges[i][1], edges[i][0], -1));
        }
        return helper(graph, source, destination, new boolean[n]);
    }

    public static boolean helper(ArrayList<Edges>[] graph, int source, int destination, boolean[] isVisited) {
        if (source == destination) {
            return true;
        }
        isVisited[source] = true;
        for (Edges edges : graph[source]) {
            if (!isVisited[edges.d] && helper(graph, edges.d, destination, isVisited)) {
                return true;
            }
        }
        return false;
    }
}
