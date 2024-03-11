package com.dsagame.leetcode.dailychallenge.feb;

public class Leetcode6 {
    public static void main(String[] args) {
        System.out.println(convert("paypalishiring", 3));
    }

    /*Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"*/

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int k = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < n) {
                str.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    int k1 = k - (2 * i);
                    int k2 = index + k1;
                    if (k2 < n) {
                        str.append(s.charAt(k2));
                    }
                }
                index = index + k;
            }
        }
        return str.toString();
    }
}
