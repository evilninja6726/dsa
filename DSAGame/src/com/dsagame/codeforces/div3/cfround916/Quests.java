package com.dsagame.codeforces.div3.cfround916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quests {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int k = ioHandler.nextInt();
            int[] a = ioHandler.readArray(n);
            int[] b = ioHandler.readArray(n);
            int sumOfA = 0;
            int maxSoFarInB = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (i == k) {
                    break;
                }
                sumOfA += a[i];
                maxSoFarInB = Math.max(maxSoFarInB, b[i]);
                res = Math.max(res, sumOfA + maxSoFarInB * (k - i - 1));
            }
            System.out.println(res);
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
