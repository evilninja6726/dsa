package com.dsagame.leetcode.graphs.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode802 {
    public static void main(String[] args) {
        int[][] inputList = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(inputList));

        int[][] inputList1 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println(eventualSafeNodes(inputList1));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Edge>[] convertedGraph = new ArrayList[graph.length];
        Set<Integer> terminalNodes = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                terminalNodes.add(i);
            }
            convertedGraph[i] = new ArrayList<>();
        }
        graphConverter(convertedGraph, graph);
        List<Integer> res = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.length];
        boolean[] pathVisitedSoFar = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (terminalNodes.contains(i) || (!pathVisitedSoFar[i] && !isCycle(convertedGraph, i, isVisited, pathVisitedSoFar))) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph, int source, boolean[] isVisited, boolean[] pathVisitedSoFar) {
        isVisited[source] = true;
        pathVisitedSoFar[source] = true;
        for (Edge edge : graph[source]) {
            if (pathVisitedSoFar[edge.d]) {
                return true;
            }
            if (!isVisited[edge.d] && isCycle(graph, edge.d, isVisited, pathVisitedSoFar)) {
                return true;
            }
        }
        pathVisitedSoFar[source] = false;
        return false;
    }

    public static void graphConverter(ArrayList<Edge>[] convertedGraph, int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int x : graph[i]) {
                convertedGraph[i].add(new Edge(i, x));
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
