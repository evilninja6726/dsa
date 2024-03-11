package com.dsagame.pepcoding.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SpreadInfection {
    public static void main(String[] args) {
        ArrayList<Edges>[] graph = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {5, 6}};
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edges(edges[i][0], edges[i][1], -1));
            graph[edges[i][1]].add(new Edges(edges[i][1], edges[i][0], -1));
        }
        System.out.println(spreadInfection(7, graph, 6, 3));
    }

    public static int spreadInfection(int n, ArrayList<Edges>[] graph, int source, int time) {
        int res = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(source, 1));
        int[] isVisited = new int[n];
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            if (isVisited[front.vertex] > 0) {
                continue;
            }
            isVisited[front.vertex] = front.time;
            if (front.time > time) {
                break;
            }
            res++;
            for (Edges edges : graph[front.vertex]) {
                if (isVisited[edges.d] == 0) {
                    queue.offer(new Pair(edges.d, front.time + 1));
                }
            }
        }
        return res;
    }

    private static class Pair {
        int vertex;
        int time;

        public Pair(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }
}
