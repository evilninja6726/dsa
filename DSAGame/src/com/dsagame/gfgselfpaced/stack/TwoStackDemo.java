package com.dsagame.gfgselfpaced.stack;

public class TwoStackDemo {
    public static void main(String[] args) {
        TwoStacks twoStack = new TwoStacks(6);
        System.out.println(twoStack);
        System.out.println(twoStack.size1());
        System.out.println(twoStack.size2());
        twoStack.push2(1);
        twoStack.push2(2);
        twoStack.push2(3);
        twoStack.push2(4);
        System.out.println(twoStack);
        System.out.println(twoStack.size1());
        System.out.println(twoStack.size2());
        twoStack.push1(5);
        twoStack.push1(6);
        System.out.println(twoStack);
        System.out.println(twoStack.size1());
        System.out.println(twoStack.size2());
        twoStack.push1(7);
        twoStack.push2(8);
        System.out.println(twoStack);
        System.out.println(twoStack.pop1());
        System.out.println(twoStack.pop2());
        System.out.println(twoStack);
        System.out.println(twoStack.size1());
        System.out.println(twoStack.size2());
    }
}
