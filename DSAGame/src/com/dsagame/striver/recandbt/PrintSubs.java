package com.dsagame.striver.recandbt;

public class PrintSubs {
    public static void main(String[] args) {
        print(new int[]{1, 2, 3}, 0, new StringBuilder());
    }

    public static void print(int[] arr, int idx, StringBuilder res) {
        if (idx == arr.length) {
            System.out.println(res);
            return;
        }
        print(arr, idx + 1, res);
        print(arr, idx + 1, res.append(arr[idx]));
        res.deleteCharAt(res.length() - 1);
    }
}
