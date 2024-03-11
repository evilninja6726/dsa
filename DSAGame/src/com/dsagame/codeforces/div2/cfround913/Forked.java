package com.dsagame.codeforces.div2.cfround913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Forked {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int a = ioHandler.nextInt();
            int b = ioHandler.nextInt();
            int xk = ioHandler.nextInt();
            int yk = ioHandler.nextInt();
            int xq = ioHandler.nextInt();
            int yq = ioHandler.nextInt();
            int[][] kPair;
            int[][] qPair;
            int res = 0;
            if (a == b) {
                kPair = new int[][]{
                        {xk + a, yk + b},
                        {xk - a, yk + b},
                        {xk + a, yk - b},
                        {xk - a, yk - b},
                };
                qPair = new int[][]{
                        {xq + a, yq + b},
                        {xq - a, yq + b},
                        {xq + a, yq - b},
                        {xq - a, yq - b},
                };
                for (int[] kp : kPair) {
                    for (int[] qp : qPair) {
                        if (kp[0] == qp[0] && kp[1] == qp[1]) {
                            res++;
                        }
                    }
                }
            } else {
                kPair = new int[][]{
                        {xk + a, yk + b},
                        {xk + b, yk + a},
                        {xk - b, yk + a},
                        {xk - a, yk + b},
                        {xk - a, yk - b},
                        {xk - b, yk - a},
                        {xk + b, yk - a},
                        {xk + a, yk - b},
                };
                qPair = new int[][]{
                        {xq + a, yq + b},
                        {xq + b, yq + a},
                        {xq - b, yq + a},
                        {xq - a, yq + b},
                        {xq - a, yq - b},
                        {xq - b, yq - a},
                        {xq + b, yq - a},
                        {xq + a, yq - b},
                };
                for (int[] kp : kPair) {
                    for (int[] qp : qPair) {
                        if (kp[0] == qp[0] && kp[1] == qp[1]) {
                            res++;
                        }
                    }
                }
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
