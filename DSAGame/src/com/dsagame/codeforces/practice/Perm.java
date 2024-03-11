package com.dsagame.codeforces.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Perm {
    static final int N = 1000005;
    static int n;
    static int m;
    static int d;
    static int ans;
    static int[] p = new int[N];
    static int[] a = new int[N];
    static boolean[] b = new boolean[N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            d = Integer.parseInt(s[2]);
            s = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(s[i - 1]);
                b[i] = false;
            }
            s = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(s[i]);
                b[a[i]] = true;
            }
            ans = 0;
            int last = -1;
            for (int i = 0; i < m; i++) {
                int x = a[i];
                int pos = 0;
                for (int j = 1; j <= n; j++) {
                    if (p[j] == x) {
                        pos = j;
                        break;
                    }
                }
                if (last != -1) {
                    if (pos > last + d) {
                        int k = last + d + 1;
                        int cnt = 0;
                        while (!b[p[k]]) {
                            cnt++;
                            k++;
                        }
                        ans += cnt;
                        for (int l = last + d; l >= last + 1; l--) {
                            int t = p[l];
                            p[l] = p[l + cnt];
                            p[l + cnt] = t;
                        }
                        last = last + cnt + d;
                    } else {
                        last = pos;
                    }
                } else {
                    last = pos;
                }
            }
            System.out.println(ans);
        }
    }
}
