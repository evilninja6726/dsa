package com.dsagame.leetcode.graphs.medium;

import java.util.*;
import java.util.stream.IntStream;

public class Leetcode207 {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.stream(prerequisites).forEach(prerequisite -> graph[prerequisite[0]].add(prerequisite[1]));
        int[] inDegree = new int[numCourses];
        Arrays.stream(graph).flatMap(List::stream).forEach(dest -> inDegree[dest]++);
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(0, numCourses).filter(i -> inDegree[i] == 0).forEach(queue::offer);
        int allElements = 0;
        while (!queue.isEmpty()) {
            int source = queue.poll();
            allElements++;
            for (int dest : graph[source]) {
                inDegree[dest]--;
                if (inDegree[dest] == 0) {
                    queue.offer(dest);
                }
            }
        }
        return allElements == numCourses;
    }
}
