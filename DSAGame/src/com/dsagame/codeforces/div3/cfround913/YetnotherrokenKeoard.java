package com.dsagame.codeforces.div3.cfround913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class YetnotherrokenKeoard {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            String s = ioHandler.nextLine();
            Stack<Pair> capital = new Stack<>();
            Stack<Pair> small = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'B') {
                    if (!capital.isEmpty()) {
                        capital.pop();
                    }
                } else if (s.charAt(i) == 'b') {
                    if (!small.isEmpty()) {
                        small.pop();
                    }
                } else {
                    if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                        capital.push(new Pair(s.charAt(i), i));
                    } else {
                        small.push(new Pair(s.charAt(i), i));
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            while (!capital.isEmpty() && !small.isEmpty()) {
                if (capital.peek().idx > small.peek().idx) {
                    res.append(capital.peek().c);
                    capital.pop();
                } else {
                    res.append(small.peek().c);
                    small.pop();
                }
            }
            if (!capital.isEmpty()) {
                while (!capital.isEmpty()) {
                    res.append(capital.pop().c);
                }
            } else if (!small.isEmpty()) {
                while (!small.isEmpty()) {
                    res.append(small.pop().c);
                }
            }
            System.out.println(res.reverse());
        }
    }

    private static class Pair {
        char c;
        int idx;

        public Pair(char c, int idx) {
            this.c = c;
            this.idx = idx;
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
