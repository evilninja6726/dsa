package com.dsagame.practice;

public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            return 10;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 20;
        }
    }
}
