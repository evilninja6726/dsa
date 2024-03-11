package com.dsagame.codeforces.div4.round918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotQuiteLatinSquare {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();
        int t = ioHandler.nextInt();
        while (t-- > 0) {
            String s1 = ioHandler.nextLine();
            String s2 = ioHandler.nextLine();
            String s3 = ioHandler.nextLine();
            boolean a = false;
            boolean b = false;
            boolean c = false;
            boolean found = false;
            for (int i = 0; i < 3; i++) {
                if (s1.charAt(i) == '?') {
                    found = true;
                } else {
                    if (s1.charAt(i) == 'A') {
                        a = true;
                    } else if (s1.charAt(i) == 'B') {
                        b = true;
                    } else {
                        c = true;
                    }
                }
            }
            if (found) {
                if (!a) {
                    System.out.println('A');
                } else if (!b) {
                    System.out.println('B');
                } else {
                    System.out.println('C');
                }
                continue;
            }
            a = b = c = false;
            for (int i = 0; i < 3; i++) {
                if (s2.charAt(i) == '?') {
                    found = true;
                } else {
                    if (s2.charAt(i) == 'A') {
                        a = true;
                    } else if (s2.charAt(i) == 'B') {
                        b = true;
                    } else {
                        c = true;
                    }
                }
            }
            if (found) {
                if (!a) {
                    System.out.println('A');
                } else if (!b) {
                    System.out.println('B');
                } else {
                    System.out.println('C');
                }
                continue;
            }
            a = b = c = false;
            for (int i = 0; i < 3; i++) {
                if (s3.charAt(i) == '?') {
                    found = true;
                } else {
                    if (s3.charAt(i) == 'A') {
                        a = true;
                    } else if (s3.charAt(i) == 'B') {
                        b = true;
                    } else {
                        c = true;
                    }
                }
            }
            if (found) {
                if (!a) {
                    System.out.println('A');
                } else if (!b) {
                    System.out.println('B');
                } else {
                    System.out.println('C');
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
