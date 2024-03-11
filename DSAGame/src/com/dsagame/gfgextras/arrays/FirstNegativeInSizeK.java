package com.dsagame.gfgextras.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FirstNegativeInSizeK {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printFirstNegativeInteger(new long[]{-8, 2, 3, -6, 10}, 5, 2)));
        System.out.println(Arrays.toString(printFirstNegativeInteger(new long[]{-8, 8}, 2, 1)));
    }

    public static long[] printFirstNegativeInteger(long[] A, int N, int K) {
        long[] res = new long[N - K + 1];
        Queue<Long> negatives = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (j < N) {
            if (A[j] < 0) {
                negatives.offer(A[j]);
            }
            if (j == i + K - 1) {
                if (negatives.isEmpty()) {
                    res[i++] = 0;
                } else if (A[i] < 0) {
                    res[i++] = negatives.poll();
                } else {
                    res[i++] = negatives.peek();
                }
            }
            j++;
        }
        return res;
    }
}
