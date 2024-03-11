package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(String s) {
        if (s.length() <= 1 || s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !balancedParenthesis(stack.peek(), s.charAt(i))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean balancedParenthesis(Character c1, Character c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || c1 == '[' && c2 == ']';
    }
}
