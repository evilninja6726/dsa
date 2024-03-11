package com.dsagame.pepcoding.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class IsCycle {
    public static void main(String[] args) {
        int n = 7; // Number of nodes
        ArrayList<Edges>[] graph = new ArrayList[n];

        // Initialize the graph with empty ArrayLists
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        ArrayList<Edges>[] graph1 = new ArrayList[n];

        // Initialize the graph with empty ArrayLists
        for (int i = 0; i < n; i++) {
            graph1[i] = new ArrayList<>();
        }
        ArrayList<Edges>[] graph2 = new ArrayList[n];

        // Initialize the graph with empty ArrayLists
        for (int i = 0; i < n; i++) {
            graph2[i] = new ArrayList<>();
        }

        // Edges: [[0,1],[0,2],[3,5],[5,4],[4,3]]
        // int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 5}, {5, 4}, {4, 3}};
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {5, 6}};
        int[][] edges1 = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {4, 6}, {5, 6}};
        int[][] edges2 = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {4, 6}};

        // Add edges to the graph
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edges(edges[i][0], edges[i][1], -1));
            graph[edges[i][1]].add(new Edges(edges[i][1], edges[i][0], -1));
        }

        for (int i = 0; i < edges1.length; i++) {
            graph1[edges1[i][0]].add(new Edges(edges1[i][0], edges1[i][1], -1));
            graph1[edges1[i][1]].add(new Edges(edges1[i][1], edges1[i][0], -1));
        }

        for (int i = 0; i < edges2.length; i++) {
            graph2[edges2[i][0]].add(new Edges(edges2[i][0], edges2[i][1], -1));
            graph2[edges2[i][1]].add(new Edges(edges2[i][1], edges2[i][0], -1));
        }
        System.out.println(isCycle(n, graph));
        System.out.println(isCycle(n, graph1));
        System.out.println(isCycle(n, graph2));
    }

    public static boolean isCycle(int n, ArrayList<Edges>[] graph) {
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
//            if (!isVisited[i] && bfs(n, graph, i, isVisited)) {
//                return true;
//            }
            if (!isVisited[i] && dfs(graph, i, -1, isVisited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean bfs(int n, ArrayList<Edges>[] graph, int source, boolean[] isVisited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (isVisited[front]) {
                return true;
            }
            isVisited[front] = true;
            for (Edges edges : graph[front]) {
                if (!isVisited[edges.d]) {
                    queue.offer(edges.d);
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<Edges>[] graph, int source, int parent, boolean[] isVisited) {
        isVisited[source] = true;
        for (Edges edges : graph[source]) {
            if (!isVisited[edges.d]) {
                if (dfs(graph, edges.d, source, isVisited)) {
                    return true;
                }
            } else if (parent != edges.d) {
                return true;
            }
        }
        return false;
    }
}
