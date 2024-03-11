package com.dsagame.codeforces.div3.cfround916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemSolvingLog {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            String s = ioHandler.nextLine();
            int[] frequency = new int[26];
            for (int i = 0; i < s.length(); i++) {
                frequency[s.charAt(i) - 'A']++;
            }
            int res = 0;
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] >= i + 1) {
                    res++;
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
