package com.dsagame.pepcoding.graphs;

import java.util.ArrayList;

public class PrintAllPaths {
    public static void main(String[] args) {
        int n = 7; // Number of nodes
        ArrayList<Edges>[] graph = new ArrayList[n];

        // Initialize the graph with empty ArrayLists
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edges: [[0,1],[0,2],[3,5],[5,4],[4,3]]
        // int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 5}, {5, 4}, {4, 3}};
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 3}, {2, 5}, {3, 4}, {4, 5}, {4, 6}, {5, 6}};

        // Add edges to the graph
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edges(edges[i][0], edges[i][1], -1));
            graph[edges[i][1]].add(new Edges(edges[i][1], edges[i][0], -1));
        }
        print(graph, 0, 6, new boolean[7], 0 + "");
    }

    public static void print(ArrayList<Edges>[] graph, int s, int d, boolean[] isVisited, String pathSoFar) {
        if (s == d) {
            System.out.println(pathSoFar);
            return;
        }
        isVisited[s] = true;
        for (Edges edges : graph[s]) {
            if (!isVisited[edges.d]) {
                print(graph, edges.d, d, isVisited, pathSoFar + edges.d);
            }
        }
        isVisited[s] = false;
    }
}
