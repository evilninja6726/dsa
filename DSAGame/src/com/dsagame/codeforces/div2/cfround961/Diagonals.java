package com.dsagame.codeforces.div2.cfround961;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Diagonals {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int k = ioHandler.nextInt();
            if (k == 0 || n == 0) {
                System.out.println(0);
                continue;
            } else if (k < n) {
                System.out.println(1);
                continue;
            }
            int res = 1;
            k -= n;
            n--;
            while (k >= 2 * n && n > 0) {
                res += 2;
                k -= (2 * n--);
            }
            if (k == 0) {
                System.out.println(res);
            } else {
                System.out.println(k > n ? res + 2 : res + 1);
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
