package com.dsagame.codeforces.div3.cfround920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Square {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int x1 = ioHandler.nextInt();
            int y1 = ioHandler.nextInt();
            int x2 = ioHandler.nextInt();
            int y2 = ioHandler.nextInt();
            int x3 = ioHandler.nextInt();
            int y3 = ioHandler.nextInt();
            int x4 = ioHandler.nextInt();
            int y4 = ioHandler.nextInt();
            if (x1 == x2) {
                int a = Math.abs(y1 - y2);
                System.out.println(a * a);
            } else if (x1 == x3) {
                int a = Math.abs(y1 - y3);
                System.out.println(a * a);
            } else {
                int a = Math.abs(y1 - y4);
                System.out.println(a * a);
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
