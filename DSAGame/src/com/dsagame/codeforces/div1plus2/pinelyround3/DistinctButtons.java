package com.dsagame.codeforces.div1plus2.pinelyround3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DistinctButtons {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            int n = ioHandler.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i] = ioHandler.readArray(2);
            }
            if (n == 1) {
                System.out.println("YES");
            } else {
                boolean xPos = false;
                boolean xNeg = false;
                boolean yPos = false;
                boolean yNeg = false;
                for (int[] point : points) {
                    int x = point[0];
                    int y = point[1];
                    if (x > 0) {
                        xPos = true;
                    } else if (x < 0) {
                        xNeg = true;
                    }
                    if (y > 0) {
                        yPos = true;
                    } else if (y < 0) {
                        yNeg = true;
                    }
                }
                if (!xPos || !yPos || !xNeg || !yNeg) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
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
