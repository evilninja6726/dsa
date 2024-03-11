package com.dsagame.striver.recandbt;

public class PrintSubsWithSumK {
    public static void main(String[] args) {
        print(new int[]{1, 2, 3, 6, 3, 5, 4}, 0, 6, new StringBuilder(), 0);
        printOne(new int[]{1, 2, 3, 6, 3, 5, 4}, 0, 6, 0, new StringBuilder());
        System.out.println(countSub(new int[]{1, 2, 3, 6, 3, 5, 4}, 0, 6, 0));
    }

    public static void print(int[] arr, int idx, int k, StringBuilder res, int sum) {
        if (idx == arr.length) {
            if (sum == k) {
                System.out.println(res);
            }
            return;
        }
        print(arr, idx + 1, k, res, sum);
        print(arr, idx + 1, k, res.append(arr[idx]), sum + arr[idx]);
        res.deleteCharAt(res.length() - 1);
    }

    public static boolean printOne(int[] arr, int idx, int k, int sum, StringBuilder res) {
        if (idx == arr.length) {
            if (k == sum) {
                System.out.println(res);
                return true;
            }
            return false;
        }
        if (printOne(arr, idx + 1, k, sum, res)) {
            return true;
        }
        if (printOne(arr, idx + 1, k, sum + arr[idx], res.append(arr[idx]))) {
            return true;
        }
        res.deleteCharAt(res.length() - 1);
        return false;
    }

    public static int countSub(int[] arr, int idx, int k, int sum) {
        if (idx == arr.length) {
            if (k == sum) {
                return 1;
            }
            return 0;
        }
        int notInclude = countSub(arr, idx + 1, k, sum);
        int include = countSub(arr, idx + 1, k, sum + arr[idx]);
        return notInclude + include;
    }
}
