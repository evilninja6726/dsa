package com.dsagame.codeforces.div2.cfround917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeastProduct {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int[] arr = ioHandler.readArray(n);
            int negCount = 0;
            boolean gotAnswer = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    System.out.println(0);
                    gotAnswer = true;
                    break;
                } else if (arr[i] < 0) {
                    negCount++;
                }
            }
            if (gotAnswer) {
                continue;
            }
            if (negCount % 2 == 1) {
                System.out.println(0);
            } else {
                System.out.println(1);
                System.out.println(1 + " " + 0);
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
