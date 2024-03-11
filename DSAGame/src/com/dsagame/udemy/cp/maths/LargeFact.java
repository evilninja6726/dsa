package com.dsagame.udemy.cp.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargeFact {
    public static void main(String[] args) {
        System.out.println(fact(60));
    }

    public static List<Integer> fact(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return new ArrayList<>(List.of(n));
        }
        List<Integer> prev = fact(n - 1);
        Collections.reverse(prev);
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (Integer digit : prev) {
            int product = n * digit + carry;
            res.add(product % 10);
            carry = product / 10;
        }
        while (carry > 0) {
            res.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
