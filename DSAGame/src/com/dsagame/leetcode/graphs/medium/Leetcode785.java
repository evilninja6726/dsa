package com.dsagame.leetcode.graphs.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Leetcode785 {
    public static void main(String[] args) {
        //  int[][] twoDArray = {{1}, {0, 3}, {3}, {1, 2}};
        int[][] twoDArray = {{1, 2, 3}, {0, 3, 4}, {0, 3}, {0, 1, 2}, {1}};

        System.out.println(isBipartite(twoDArray));
    }

    public static boolean isBipartite(int[][] graph) {
        ArrayList<Edges>[] adjList = graphConverter(graph);
        int[] isVisited = new int[graph.length];
        Arrays.fill(isVisited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (isVisited[i] == -1 && !isCycleAndBipartite(adjList, i, isVisited)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCycleAndBipartite(ArrayList<Edges>[] graph, int source, int[] isVisited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(source, 0));
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            if (isVisited[front.vertex] != -1) {
                if (isVisited[front.vertex] != front.level) {
                    return false;
                }
            } else {
                isVisited[front.vertex] = front.level;
            }
            for (Edges edges : graph[front.vertex]) {
                if (isVisited[edges.d] == -1) {
                    queue.offer(new Pair(edges.d, front.level + 1));
                }
            }
        }
        return true;
    }

    public static ArrayList<Edges>[] graphConverter(int[][] arr) {
        ArrayList<Edges>[] graph = new ArrayList[arr.length];
        for (int i = 0; i < arr.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                graph[i].add(new Edges(i, arr[i][j]));
            }
        }
        return graph;
    }

    private static class Edges {
        int s;
        int d;

        public Edges(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    private static class Pair {
        int vertex;
        int level;

        public Pair(int vertex, int level) {
            this.vertex = vertex;
            this.level = level;
        }
    }
}
