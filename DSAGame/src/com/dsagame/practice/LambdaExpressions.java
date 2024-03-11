package com.dsagame.practice;

interface Test {
    int square(int n);
}

public class LambdaExpressions {
    public static void main(String[] args) {
        Test test = n -> n * n;
        System.out.println(test.square(5));
    }
}