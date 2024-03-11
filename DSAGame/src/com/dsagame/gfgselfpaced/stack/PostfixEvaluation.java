package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;

public class PostfixEvaluation {
    public static void main(String[] args) {
        System.out.println(postfixEvaluation(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(postfixEvaluation(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(postfixEvaluation(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static boolean isOperator(String s) {
        return s.equals("^") || s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-");
    }

    public static int evaluate(String s1, String s2, String operator) {
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        switch (operator) {
            case "^":
                return (int) Math.pow(a, b);
            case "/":
                return a / b;
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                return -1;
        }
    }

    public static int postfixEvaluation(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String str : tokens) {
            if (isOperator(str)) {
                String b = stack.pop();
                String a = stack.pop();
                int eval = evaluate(a, b, str);
                stack.push(String.valueOf(eval));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
