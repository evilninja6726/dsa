package com.dsagame.codeforces.div4.round918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class RomanticGlasses {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int[] arr = ioHandler.readArray(n);
            int sum = 0;
            boolean found = false;
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) {
                    arr[i] *= -1;
                }
                sum += arr[i];
                if (set.contains(sum)) {
                    found = true;
                    break;
                }
                set.add(sum);
            }
            System.out.println(found ? "YES" : "NO");
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
