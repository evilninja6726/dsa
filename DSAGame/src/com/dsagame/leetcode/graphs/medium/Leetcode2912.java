package com.dsagame.leetcode.graphs.medium;

import java.util.*;

public class Leetcode2912 {
    public static void main(String[] args) {
        int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        System.out.println(getAncestors(8, edges));
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer>[] convertedGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            convertedGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            convertedGraph[edges[i][0]].add(edges[i][1]);
        }
        int[] inDegree = new int[n];
        Arrays.stream(convertedGraph).flatMap(ArrayList::stream).forEach(node -> inDegree[node]++);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int source = queue.poll();
            for (int destination : convertedGraph[source]) {
                Set<Integer> parent = new HashSet<>(res.get(source));
                parent.add(source);
                parent.addAll(res.get(destination));
                List<Integer> individualList = new ArrayList<>(parent);
                Collections.sort(individualList);
                res.set(destination, individualList);
                inDegree[destination]--;
                if (inDegree[destination] == 0) {
                    queue.offer(destination);
                }
            }
        }
        return res;
    }
}
