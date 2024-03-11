package com.dsagame.pepcoding.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class MinSwapToSortArray {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{2, 4, 5, 1, 3}));
        System.out.println(minSwaps(new int[]{1, 5, 4, 3, 2}));
    }


    public static int minSwaps(int[] arr) {
        Pair[] pairs = IntStream.range(0, arr.length).mapToObj(i -> new Pair(i, arr[i])).toArray(Pair[]::new);
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });
        int res = 0;
        boolean[] isVisited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (pairs[i].index != i && !isVisited[i]) {
                int cycle = 0;
                int j = i;
                while (!isVisited[j]) {
                    isVisited[j] = true;
                    cycle++;
                    j = pairs[j].index;
                }
                res += cycle - 1;
            }

        }
        return res;
    }

    private static class Pair {
        int index, value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}
