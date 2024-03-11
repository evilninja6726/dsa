package com.dsagame.codeforces.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WayTooLongWords {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int n = ioHandler.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = ioHandler.nextLine();
        }
        for (int i = 0; i < n; i++) {
            if (words[i].length() > 10) {
                System.out.println(words[i].charAt(0) + "" + (words[i].length() - 2) + "" + words[i].charAt(words[i].length() - 1));
            } else {
                System.out.println(words[i]);
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
