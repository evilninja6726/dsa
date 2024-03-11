package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;

public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public static String infixToPostfix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                stack.push(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                stack.pop();
            } else if (Character.isLetterOrDigit(exp.charAt(i))) {
                res.append(exp.charAt(i));
            } else {
                while (!stack.isEmpty() && precedence(exp.charAt(i)) <= precedence(stack.peek())) {
                    res.append(stack.pop());
                }
                stack.push(exp.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static int precedence(char c) {
        switch (c) {
            case '^':
                return 2;
            case '/':
            case '*':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }
}
