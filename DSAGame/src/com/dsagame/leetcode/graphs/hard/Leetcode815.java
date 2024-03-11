package com.dsagame.leetcode.graphs.hard;

import java.util.*;

public class Leetcode815 {
    public static void main(String[] args) {
        //  System.out.println(numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        // System.out.println(numBusesToDestination(new int[][]{{2}, {2, 8}}, 8, 2));
        // System.out.println(numBusesToDestination(new int[][]{{1, 7}, {3, 5}}, 5, 5));
        System.out.println(numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 8, 6));
    }

    // [[1,2,7],[3,6,7]], source = 1, target = 6
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> busRouteMap = new HashMap<>();
        Set<Integer> isBusRouteVisited = new HashSet<>();
        Set<Integer> isBusStopVisited = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                busRouteMap.computeIfAbsent(routes[i][j], newRoute -> new ArrayList<>()).add(i);
            }
        }
        if (!busRouteMap.containsKey(source)) {
            return -1;
        }
        for (int route : busRouteMap.get(source)) {
            for (int j = 0; j < routes[route].length; j++) {
                if (!isBusStopVisited.contains(routes[route][j])) {
                    queue.offer(new Pair(routes[route][j], 1));
                    isBusStopVisited.add(routes[route][j]);
                }
            }
            isBusRouteVisited.add(route);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            if (front.busStop == target) {
                res = front.minBusCount;
                return res;
            }
            res = front.minBusCount;
            for (int route : busRouteMap.get(front.busStop)) {
                if (isBusRouteVisited.contains(route)) {
                    continue;
                }
                for (int j = 0; j < routes[route].length; j++) {
                    if (isBusStopVisited.contains(routes[route][j])) {
                        continue;
                    }
                    queue.offer(new Pair(routes[route][j], front.minBusCount + 1));
                    isBusStopVisited.add(routes[route][j]);
                }
                isBusRouteVisited.add(route);
            }
        }
        return -1;
    }

    private static class Pair {
        int busStop, minBusCount;

        public Pair(int busStop, int minBusCount) {
            this.busStop = busStop;
            this.minBusCount = minBusCount;
        }
    }
}
