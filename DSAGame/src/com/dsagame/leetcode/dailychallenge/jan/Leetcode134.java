package com.dsagame.leetcode.dailychallenge.jan;

public class Leetcode134 {
    public static void main(String[] args) {
        //gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        System.out.println(canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasLeft = 0;
        int res = 0;
        int currGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currGas += (gas[i] - cost[i]);
            gasLeft += (gas[i] - cost[i]);
            if (currGas < 0) {
                res = i + 1;
                currGas = 0;
            }
        }
        return (gasLeft < 0) ? -1 : res;
    }
}
