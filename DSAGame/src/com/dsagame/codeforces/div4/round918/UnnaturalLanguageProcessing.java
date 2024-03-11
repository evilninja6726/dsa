package com.dsagame.codeforces.div4.round918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class UnnaturalLanguageProcessing {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            String s = ioHandler.nextLine();
            Stack<String> stack = new Stack<>();
            for (int i = 1; i < s.length(); ) {
                char p = s.charAt(i - 1);
                char c = s.charAt(i);
                if (c == 'a' || c == 'e') {
                    stack.push(String.valueOf(p) + c);
                    i += 2;
                } else {
                    stack.push(stack.pop() + p);
                    i++;
                }
            }
            StringBuilder res = new StringBuilder();
            int len = 0;
            while (!stack.isEmpty()) {
                len += stack.peek().length();
                res.append(new StringBuilder(stack.pop()).reverse()).append('.');
            }
            res.deleteCharAt(res.length() - 1);
            if (len != s.length()) {
                System.out.println(res.reverse().append(s.charAt(n - 1)));
            } else {
                System.out.println(res.reverse());
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
