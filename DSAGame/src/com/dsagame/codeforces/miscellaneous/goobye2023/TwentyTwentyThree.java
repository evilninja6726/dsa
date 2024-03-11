package com.dsagame.codeforces.miscellaneous.goobye2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwentyTwentyThree {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int k = ioHandler.nextInt();
            int[] b = ioHandler.readArray(n);
            int prod = 1;
            boolean no = false;
            for (int i = 0; i < n; i++) {
                prod *= b[i];
            }
            if (prod == 2023) {
                System.out.println("YES");
                while (k-- > 0) {
                    System.out.print(1 + " ");
                }
            } else if (2023 % prod != 0) {
                no = true;
                System.out.println("NO");
            } else {
                int num = 2023 / prod;
                System.out.println("YES");
                System.out.print(num + " ");
                while (k-- > 1) {
                    System.out.print(1 + " ");
                }
            }
            if (!no) {
                System.out.println();
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
