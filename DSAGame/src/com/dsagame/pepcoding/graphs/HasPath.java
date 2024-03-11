package com.dsagame.pepcoding.graphs;

import java.util.ArrayList;

public class HasPath {
    public static void main(String[] args) {

    }

    public static boolean hasPath(ArrayList<Edges>[] graph, int s, int d) {
        if (s == d) {
            return true;
        }
        for (Edges edges : graph[s]) {
            if (hasPath(graph, edges.d, d)) {
                return true;
            }
        }
        return false;
    }

    public static boolean helper(ArrayList<Edges>[] graph, int s, int d, boolean[] isVisited) {
        if (s == d) {
            return true;
        }
        isVisited[s] = true;
        for (Edges edges : graph[s]) {
            if (!isVisited[edges.d] && hasPath(graph, edges.s, d)) {
                return true;
            }
        }
        return false;
    }
}
