package com.dsagame.codeforces.div1plus2.pinelyround3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MakeAlmostEqualWithMod {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            long[] arr = new long[n];
            arr = ioHandler.readLongArray(n);
            if (n == 2) {
                System.out.println(1000000000000000000L);
                continue;
            }
            long k = 2L;
            while (true) {
                Set<Long> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    set.add(arr[i] % k);
                    if (set.size() > 2) {
                        break;
                    }
                }
                if (set.size() == 2) {
                    System.out.println(k);
                    break;
                }
                k *= 2;
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

        long[] readLongArray(int n) {
            long[] res = new long[n];

            for (int i = 0; i < n; ++i)
                res[i] = nextLong();

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
