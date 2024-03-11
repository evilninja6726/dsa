package com.dsagame.pepcoding.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int n = 7;
        ArrayList<Edges>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edges(0, 1, 10));
        graph[0].add(new Edges(0, 3, 40));
        graph[1].add(new Edges(1, 2, 10));
        // graph[1].add(new Edges(1, 0, 10));
        //   graph[2].add(new Edges(2, 1, 10));
        graph[2].add(new Edges(2, 3, 10));
        //    graph[3].add(new Edges(3, 0, 40));
        //    graph[3].add(new Edges(3, 4, 2));
        graph[4].add(new Edges(4, 3, 2));
        graph[4].add(new Edges(4, 5, 3));
        graph[4].add(new Edges(4, 6, 5));
        //  graph[5].add(new Edges(5, 4, 3));
        graph[5].add(new Edges(5, 6, 3));
        //  graph[6].add(new Edges(6, 4, 8));
        //    graph[6].add(new Edges(6, 5, 3));
        topologicalSort(n, graph);
    }

    public static void topologicalSort(int n, ArrayList<Edges>[] graph) {
        boolean[] isVisited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                helper(graph, i, stack, isVisited);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void helper(ArrayList<Edges>[] graph, int source, Stack<Integer> stack, boolean[] isVisited) {
        isVisited[source] = true;
        for (Edges edges : graph[source]) {
            if (!isVisited[edges.d]) {
                helper(graph, edges.d, stack, isVisited);
            }
        }
        stack.push(source);
    }
}
