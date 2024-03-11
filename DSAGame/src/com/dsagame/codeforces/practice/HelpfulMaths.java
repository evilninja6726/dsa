package com.dsagame.codeforces.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HelpfulMaths {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        String s = ioHandler.nextLine();
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) == '1') {
                one++;
            } else if (s.charAt(i) == '2') {
                two++;
            } else {
                three++;
            }
        }
        StringBuilder res = new StringBuilder();
        int totalCount = one + two + three;
        while (totalCount > 0) {
            while (one-- > 0) {
                res.append(1).append("+");
                totalCount--;
            }
            while (two-- > 0) {
                res.append(2).append("+");
                totalCount--;
            }
            while (three-- > 0) {
                res.append(3).append("+");
                totalCount--;
            }
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println(res);
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
