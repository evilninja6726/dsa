package com.dsagame.codingblock.recursion.recursion_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllOccurrences {
    public static void main(String[] args) {
        allOccurrence(new int[]{1, 2, 3, 4, 53, 3, 2, 4, 5, 3, 22, 2, 2, 3, 45}, 0, 2);
        System.out.println();
        System.out.println(Arrays.toString(storeAllOccurrences(new int[]{1, 2, 3, 4, 53, 3, 2, 4, 5, 3, 22, 2, 2, 3, 45}, 0, 2, new ArrayList<>())));
    }

    public static void allOccurrence(int[] arr, int i, int x) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == x) {
            System.out.print(i + " ");
        }
        allOccurrence(arr, i + 1, x);
    }

    public static int[] storeAllOccurrences(int[] arr, int i, int x, List<Integer> res) {
        if (i == arr.length) {
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
        if (arr[i] == x) {
            res.add(i);
        }
        return storeAllOccurrences(arr, i + 1, x, res);
    }
}
