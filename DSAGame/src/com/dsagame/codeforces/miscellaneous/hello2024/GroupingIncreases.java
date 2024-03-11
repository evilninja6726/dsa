package com.dsagame.codeforces.miscellaneous.hello2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GroupingIncreases {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int[] arr = ioHandler.readArray(n);
            int lds = lds(arr);

        }
    }

    public static int lds(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[] tail = new int[arr.length];
        int length = 1;
        tail[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tail[length - 1]) {
                tail[length++] = arr[i];
            } else {
                int idx = Arrays.binarySearch(tail, 0, length - 1, arr[i]);
                if (idx < 0) {
                    idx = -1 * idx - 1;
                }
                tail[idx] = arr[i];
            }
        }
        return length;
    }

    private static class IOHandler {
        BufferedReader br;
        StringTokenizer st;

        public IOHandler() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] res = new int[n];

            for (int i = 0; i < n; ++i)
                res[i] = nextInt();

            return res;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
