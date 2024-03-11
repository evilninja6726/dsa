package com.dsagame.gfgselfpaced.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeKSortedArrays(new int[][]{
                {10, 20, 30},
                {6, 15},
                {4, 9, 11}
        })));
    }

    public static int[] mergeKSortedArrays(int[][] arr) {
        int k = 0;
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>(arr.length, new Comparator<Triplet>() {
            @Override
            public int compare(Triplet o1, Triplet o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            k += arr[i].length;
            minHeap.add(new Triplet(arr[i][0], i, 0));
        }
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            Triplet root = minHeap.poll();
            res[i++] = root.value;
            if (++root.index < arr[root.arrNum].length) {
                minHeap.add(new Triplet(arr[root.arrNum][root.index], root.arrNum, root.index));
            }
        }
        return res;
    }


    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>(K, new Comparator<Triplet>() {
            @Override
            public int compare(Triplet o1, Triplet o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 0; i < K; i++) {
            minHeap.add(new Triplet(arr[i][0], i, 0));
        }
        while (!minHeap.isEmpty()) {
            Triplet root = minHeap.poll();
            res.add(root.value);
            if (++root.index < arr[root.arrNum].length) {
                minHeap.add(new Triplet(arr[root.arrNum][root.index], root.arrNum, root.index));
            }
        }
        return res;
    }
}

class Triplet {
    int value;
    int arrNum;
    int index;

    public Triplet(int value, int arrNum, int index) {
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }
}
