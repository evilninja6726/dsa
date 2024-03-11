package com.dsagame.codeforces.div2.cfround917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class EraseFirstOrSecondLetter {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            String s = ioHandler.nextLine();
            int[] dp = new int[n];
            if (n == 1) {
                System.out.println(1);
            } else {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < s.length(); i++) {
                    set.add(s.charAt(i));
                }
                System.out.println((int) ((Math.pow(2, set.size())) - 1));
            }
        }
    }

//    public static void helper(String s, int[] res, Set<String> dp) {
//        if (dp.contains(s)) {
//            return;
//        }
//        if (s.length() == 1) {
//            dp.add(s);
//            res[0] += 1;
//            return;
//        }
//        StringBuilder s1 = new StringBuilder(s);
//        s1.deleteCharAt(0);
//        StringBuilder s2 = new StringBuilder(s);
//        s2.deleteCharAt(1);
//        helper(s1.toString(), res, dp);
//        helper(s2.toString(), res, dp);
//        dp.add(s);
//        res[0] += 1;
//    }

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
