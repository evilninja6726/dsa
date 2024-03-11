package com.dsagame.gfgselfpaced.arrays;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trappingRainWater(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public static int trappingRainWater(int[] height) {
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }
        int res = 0;
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];
        lMax[0] = height[0];
        rMax[height.length - 1] = height[height.length - 1];
        System.out.println(rMax[0]);
        for (int i = 1, j = height.length - 2; i < height.length && j >= 0; i++, j--) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
            rMax[j] = Math.max(height[j], rMax[j + 1]);
        }
        System.out.println(Arrays.toString(lMax));
        System.out.println(Arrays.toString(rMax));
        for (int i = 1; i < height.length - 1; i++) {
            res += (Math.min(lMax[i], rMax[i]) - height[i]);
        }
        return res;
    }
}
