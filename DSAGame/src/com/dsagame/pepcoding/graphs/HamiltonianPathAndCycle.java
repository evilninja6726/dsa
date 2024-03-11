package com.dsagame.pepcoding.graphs;

import java.util.ArrayList;

public class HamiltonianPathAndCycle {
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
        print(n, graph);
    }

    public static void print(int n, ArrayList<Edges>[] graph) {
        helper(n, graph, 0, new boolean[n], "0");
    }

    public static boolean isHamiltonianCycle(ArrayList<Edges>[] graph, String path) {
        ArrayList<Edges> sourceListNodes = graph[Character.getNumericValue(path.charAt(0))];
        for (Edges sourceListNode : sourceListNodes) {
            if (sourceListNode.d == Character.getNumericValue(path.charAt(path.length() - 1))) {
                return true;
            }
        }
        return false;
    }

    public static void helper(int n, ArrayList<Edges>[] graph, int s, boolean[] isVisited, String pathSoFar) {
        if (pathSoFar.length() == n) {
            if (isHamiltonianCycle(graph, pathSoFar)) {
                pathSoFar += "*";
            } else {
                pathSoFar += "$";
            }
            System.out.println(pathSoFar);
            return;
        }
        isVisited[s] = true;
        for (Edges edges : graph[s]) {
            if (!isVisited[edges.d]) {
                helper(n, graph, edges.d, isVisited, pathSoFar + edges.d);
            }
        }
        isVisited[s] = false;
    }
}
