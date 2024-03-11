package com.dsagame.codeforces.div2.cfround915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BegginerZelda {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int[][] arr = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                arr[i][0] = ioHandler.nextInt();
                arr[i][1] = ioHandler.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] edge : arr) {
                for (int x : edge) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                }
            }
            int leafNodes = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    leafNodes++;
                }
            }
            if (leafNodes % 2 == 0) {
                System.out.println(leafNodes / 2);
            } else {
                System.out.println(leafNodes / 2 + 1);
            }
        }
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
