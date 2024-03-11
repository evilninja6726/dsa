package com.dsagame.striver.graph;

import java.util.*;
import java.util.stream.IntStream;

public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println(findOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"}, 5, 4));
        // System.out.println(findOrder(new String[]{"caa", "aaa", "aab"}, 3, 3));
    }

    public static String findOrder(String[] dict, int N, int K) {
        List<Integer>[] graph = new List[K];
        for (int i = 0; i < K; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < dict[i].length() && j < dict[i - 1].length(); j++) {
                if (dict[i].charAt(j) != dict[i - 1].charAt(j)) {
                    graph[dict[i - 1].charAt(j) - 'a'].add(dict[i].charAt(j) - 'a');
                    break;
                }
            }
        }
        return cycleDetection(graph, K);
    }

    public static String cycleDetection(List<Integer>[] graph, int k) {
        int[] inDegree = new int[k];
        Arrays.stream(graph).flatMap(List::stream).forEach(node -> inDegree[node]++);
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.range(0, k).filter(i -> inDegree[i] == 0).forEach(queue::offer);
        Stack<Character> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int source = queue.poll();
            stack.push((char) (source + 'a'));
            for (int dest : graph[source]) {
                inDegree[dest]--;
                if (inDegree[dest] == 0) {
                    queue.offer(dest);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character character : stack) {
            res.append(character);
        }
        return res.toString();
    }
}
