package com.dsagame.codeforces.round848;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlipFlopSum {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = ioHandler.nextInt();
            }
            int totalSum = arr[0];
            boolean isMinusOne = arr[0] == -1;
            boolean isMinusTwo = false;
            for (int i = 1; i < n; i++) {
                if (!isMinusTwo && arr[i] == -1 && arr[i] == arr[i - 1]) {
                    isMinusOne = true;
                    isMinusTwo = true;
                } else if (arr[i] == -1) {
                    isMinusOne = true;
                }
                totalSum += arr[i];
            }
            if (isMinusTwo) {
                System.out.println(totalSum + 4);
            } else if (isMinusOne) {
                System.out.println(totalSum);
            } else {
                System.out.println(totalSum - 4);
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
