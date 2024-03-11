package com.dsagame.pepcoding.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        int n = 7; // Number of nodes
        ArrayList<Edges>[] graph = new ArrayList[n];

        // Initialize the graph with empty ArrayLists
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edges: [[0,1],[0,2],[3,5],[5,4],[4,3]]
        // int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 5}, {5, 4}, {4, 3}};
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {5, 6}};

        // Add edges to the graph
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edges(edges[i][0], edges[i][1], -1));
            graph[edges[i][1]].add(new Edges(edges[i][1], edges[i][0], -1));
        }
        bfs(n, graph, 2);
    }

    public static void bfs(int n, ArrayList<Edges>[] graph, int source) {
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        queue.offer(new Pair(source, source + ""));
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            if (isVisited[front.vertex]) {
                continue;
            }
            isVisited[front.vertex] = true;
            System.out.println(front.vertex + "@" + front.pathSoFar);
            for (Edges edges : graph[front.vertex]) {
                if (!isVisited[edges.d]) {
                    queue.offer(new Pair(edges.d, front.pathSoFar + edges.d));
                }
            }
        }
    }

    private static class Pair {
        int vertex;
        String pathSoFar;

        public Pair(int vertex, String pathSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }
}

