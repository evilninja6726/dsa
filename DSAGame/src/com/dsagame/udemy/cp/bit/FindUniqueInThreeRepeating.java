package com.dsagame.udemy.cp.bit;

public class FindUniqueInThreeRepeating {
    public static void main(String[] args) {
        System.out.println(find(new int[]{1, 8, 9, 4, 8, 9, 2, 2, 2, 1, 4, 7, 9, 8, 1, 4}));
        System.out.println(findNoSpace(new int[]{1, 8, 9, 4, 8, 9, 2, 2, 2, 1, 4, 7, 9, 8, 1, 4}));
    }

    public static int findNoSpace(int[] nums) {
        int threeN = -1, threeNPlusOne = 0, threeNPlusTwo = 0;
        for (int num : nums) {
            int commonInThreeN = num & threeN;
            int commonInThreeNPlusOne = num & threeNPlusOne;
            int commonInThreeNPlusTwo = num & threeNPlusTwo;
            threeN ^= commonInThreeN;
            threeNPlusOne |= commonInThreeN;
            threeNPlusOne ^= commonInThreeNPlusOne;
            threeNPlusTwo |= commonInThreeNPlusOne;
            threeNPlusTwo ^= commonInThreeNPlusTwo;
            threeN |= commonInThreeNPlusTwo;
        }
        return threeNPlusOne;
    }

    public static int find(int[] nums) {
        int[] sumOfBits = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if ((x & (1 << i)) > 0) {
                    sumOfBits[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            sumOfBits[i] %= 3;
            res += (sumOfBits[i] * (1 << i));
        }
        return res;
    }
}
