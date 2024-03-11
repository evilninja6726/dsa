package com.dsagame.striver.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int numVertices = 5;
        List<List<Integer>> adjacencyMatrix = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyMatrix.add(new ArrayList<>());
        }

        addEdge(adjacencyMatrix, 0, 1);
        addEdge(adjacencyMatrix, 0, 2);
        addEdge(adjacencyMatrix, 1, 2);
        addEdge(adjacencyMatrix, 1, 3);
        addEdge(adjacencyMatrix, 2, 4);
        addEdge(adjacencyMatrix, 3, 4);

        bfs(adjacencyMatrix, numVertices, 0);
    }

    // Function to add an undirected edge to the adjacency matrix
    private static void addEdge(List<List<Integer>> adjacencyMatrix, int vertex1, int vertex2) {
        // Since it's an undirected graph, we update both entries
        adjacencyMatrix.get(vertex1).add(vertex2);
        adjacencyMatrix.get(vertex2).add(vertex1);
    }

    public static void bfs(List<List<Integer>> graph, int v, int source) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[v];
        queue.offer(source);
        isVisited[source] = true;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            System.out.print(front + " ");
            for (Integer node : graph.get(front)) {
                if (!isVisited[node]) {
                    queue.offer(node);
                    isVisited[node] = true;
                }
            }
        }
    }
}
