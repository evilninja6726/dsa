package com.dsagame.striver.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

public class KahnAlgorithm {
    public static void main(String[] args) {
        int n = 7;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 2));
        // graph[1].add(new Edge(1, 0, 10));
        //   graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3));
        //    graph[3].add(new Edge(3, 0, 40));
        //    graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 6));
        //  graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6));
        //  graph[6].add(new Edge(6, 4, 8));
        //    graph[6].add(new Edge(6, 5, 3));
        kahn(graph);
    }

    public static void kahn(ArrayList<Edge>[] graph) {
        int[] inDegree = new int[graph.length];
        Arrays.stream(graph).flatMap(ArrayList::stream).forEach(node -> inDegree[node.d]++);
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(0, inDegree.length).filter(i -> inDegree[i] == 0).forEach(queue::offer);
        System.out.println(Arrays.toString(inDegree));
        System.out.println(queue);
        while (!queue.isEmpty()) {
            int front = queue.poll();
            System.out.print(front + " ");
            for (Edge edge : graph[front]) {
                inDegree[edge.d]--;
                if (inDegree[edge.d] == 0) {
                    queue.offer(edge.d);
                }
            }
        }
    }

    private static class Edge {
        int s, d;

        public Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }
}
