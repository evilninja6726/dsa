package com.dsagame.leetcode.graphs.medium;

import java.util.*;
import java.util.stream.IntStream;

public class Leetcode210 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.stream(prerequisites).forEach(prerequisite -> graph[prerequisite[0]].add(prerequisite[1]));
        int[] inDegree = new int[numCourses];
        Arrays.stream(graph).flatMap(List::stream).forEach(dest -> inDegree[dest]++);
        System.out.println(Arrays.toString(inDegree));
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(0, numCourses).filter(i -> inDegree[i] == 0).forEach(queue::offer);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int source = queue.poll();
            stack.push(source);
            for (int dest : graph[source]) {
                inDegree[dest]--;
                if (inDegree[dest] == 0) {
                    queue.offer(dest);
                }
            }
        }
        if (stack.size() != numCourses) {
            return new int[0];
        } else {
            return IntStream.range(0, stack.size())
                    .map(i -> stack.pop())
                    .toArray();
        }
    }
}
