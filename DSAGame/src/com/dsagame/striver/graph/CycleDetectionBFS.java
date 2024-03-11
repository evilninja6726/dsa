package com.dsagame.striver.graph;

import java.util.*;
import java.util.stream.IntStream;

public class CycleDetectionBFS {
    public static void main(String[] args) {
        List<Integer>[] graph = new List[5];
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[1].add(2);
        graph[2].add(3);
        graph[2].add(4);
        graph[4].add(1);
        System.out.println(isCycle(5, graph));
    }

    public static boolean isCycle(int n, List<Integer>[] graph) {
        int[] inDegree = new int[n];
        Arrays.stream(graph).flatMap(List::stream).forEach(node -> inDegree[node]++);
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(0, inDegree.length).filter(i -> inDegree[i] == 0).forEach(queue::offer);
        int allElements = 0;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            allElements++;
            for (int edge : graph[front]) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        return n != allElements;
    }
}
