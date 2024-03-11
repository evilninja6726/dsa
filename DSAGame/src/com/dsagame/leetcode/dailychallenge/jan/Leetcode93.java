package com.dsagame.leetcode.dailychallenge.jan;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    public static void main(String[] args) {

    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    public static void helper(String s, int index, List<String> part, List<String> res) {
        if (index == s.length() && part.size() == 4) {
            String ip = part.get(0) + "." + part.get(1) + "." + part.get(2) + "." + part.get(3);
            res.add(ip);
        } else if (index == s.length() || part.size() == 4) {
            return;
        }
        for (int length = 1; length <= 3 && index + length <= s.length(); length++) {
            String currString = s.substring(index, index + length);
            int intValue = Integer.parseInt(currString);
            if (intValue > 255 || (length > 2 && currString.charAt(0) == '0')) {
                break;
            }
            part.add(currString);
            helper(s, index + length, part, res);
            part.remove(part.size() - 1);
        }
    }
}
