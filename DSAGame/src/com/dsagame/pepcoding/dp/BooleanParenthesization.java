package com.dsagame.pepcoding.dp;

public class BooleanParenthesization {
    public static void main(String[] args) {
        // System.out.println(ways("TFT", "^&"));
        System.out.println(ways("TFTF", "&|^"));
    }

    public static int ways(String boolStr, String oprStr) {
        int[][] trueDp = new int[boolStr.length()][boolStr.length()];
        int[][] falseDp = new int[boolStr.length()][boolStr.length()];
        for (int gap = 0; gap < trueDp.length; gap++) {
            for (int i = 0, j = gap; i < trueDp.length && j < trueDp[0].length; i++, j++) {
                if (gap == 0) {
                    if (boolStr.charAt(i) == 'T') {
                        trueDp[i][j] = 1;
                    } else {
                        falseDp[i][j] = 1;
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        int leftTrue = trueDp[i][k];
                        int rightTrue = trueDp[k + 1][j];
                        int leftFalse = falseDp[i][k];
                        int rightFalse = falseDp[k + 1][j];
                        if (oprStr.charAt(k) == '&') {
                            trueDp[i][j] += (leftTrue * rightTrue);
                            falseDp[i][j] += ((leftFalse * rightFalse) + (leftTrue * rightFalse) + (leftFalse * rightTrue));
                        } else if (oprStr.charAt(k) == '|') {
                            trueDp[i][j] += ((rightTrue * leftTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue));
                            falseDp[i][j] += (leftFalse * rightFalse);
                        } else {
                            trueDp[i][j] += ((leftTrue * rightFalse) + (leftFalse * rightTrue));
                            falseDp[i][j] += ((leftTrue * rightTrue) + (leftFalse * rightFalse));
                        }
                    }
                }
            }
        }
        return trueDp[0][trueDp.length - 1];
    }
}
