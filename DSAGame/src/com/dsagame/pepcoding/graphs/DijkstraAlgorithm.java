package com.dsagame.pepcoding.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int n = 7;
        ArrayList<Edges>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edges(0, 1, 10));
        graph[0].add(new Edges(0, 3, 40));
        graph[1].add(new Edges(1, 2, 10));
        graph[1].add(new Edges(1, 0, 10));
        graph[2].add(new Edges(2, 1, 10));
        graph[2].add(new Edges(2, 3, 10));
        graph[3].add(new Edges(3, 0, 40));
        graph[3].add(new Edges(3, 2, 10));
        graph[3].add(new Edges(3, 4, 2));
        graph[4].add(new Edges(4, 3, 2));
        graph[4].add(new Edges(4, 5, 3));
        graph[4].add(new Edges(4, 6, 5));
        graph[5].add(new Edges(5, 4, 3));
        graph[5].add(new Edges(5, 6, 3));
        graph[6].add(new Edges(6, 4, 8));
        graph[6].add(new Edges(6, 5, 3));
        printMinWeightPath(n, graph);
    }

    public static void printMinWeightPath(int n, ArrayList<Edges>[] graph) {
        PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>(new Comparator<Triplet>() {
            @Override
            public int compare(Triplet t1, Triplet t2) {
                return t1.weight - t2.weight;
            }
        });
        priorityQueue.offer(new Triplet(0, "0", 0));
        boolean[] isVisited = new boolean[n];
        while (!priorityQueue.isEmpty()) {
            Triplet top = priorityQueue.poll();
            if (isVisited[top.vertex]) {
                continue;
            }
            isVisited[top.vertex] = true;
            System.out.println(top.vertex + "@" + top.pathSoFar + "@" + top.weight);
            for (Edges edges : graph[top.vertex]) {
                if (!isVisited[edges.d]) {
                    priorityQueue.offer(new Triplet(edges.d, top.pathSoFar + edges.d, top.weight + edges.w));
                }
            }
        }
    }

    private static class Triplet {
        int vertex;
        String pathSoFar;
        int weight;

        public Triplet(int vertex, String pathSoFar, int weight) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.weight = weight;
        }
    }
}
