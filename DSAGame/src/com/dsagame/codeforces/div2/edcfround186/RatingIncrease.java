package com.dsagame.codeforces.div2.edcfround186;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RatingIncrease {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            String num = ioHandler.nextLine();
            int len = num.length() / 2;
            boolean allVisited = true;
            for (int i = 1; i < num.length(); i++) {
                if (i == len + 1) {
                    System.out.println(-1);
                    allVisited = false;
                    break;
                } else if (num.charAt(i) != '0') {
                    int a = Integer.parseInt(num.substring(0, i));
                    int b = Integer.parseInt(num.substring(i));
                    if (a < b) {
                        allVisited = false;
                        System.out.println(a + " " + b);
                        break;
                    }
                }
            }
            if (allVisited) {
                System.out.println(-1);
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
