package com.dsagame.codeforces.div3.cfround920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class VeryDifferentArray {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int m = ioHandler.nextInt();
            List<Integer> a = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                a.add(ioHandler.nextInt());
            }
            List<Integer> b = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                b.add(ioHandler.nextInt());
            }
            Collections.sort(a);
            Collections.sort(b);
            long d = 0;
            int ia = 0, ib = 0, ja = a.size() - 1, jb = b.size() - 1;
            while (ia < ja) {
                if (Math.abs(b.get(jb) - a.get(ia)) >= Math.abs(a.get(ja) - b.get(ib))) {
                    d += Math.abs(b.get(jb--) - a.get(ia++));
                } else {
                    d += Math.abs(a.get(ja--) - b.get(ib++));
                }
            }
            if (ia == ja) {
                d += Math.max(Math.abs(b.get(jb) - a.get(ia)), Math.abs(a.get(ja) - b.get(ib)));
            }
            System.out.println(d);
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
