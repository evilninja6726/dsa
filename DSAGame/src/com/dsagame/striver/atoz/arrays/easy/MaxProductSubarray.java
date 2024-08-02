package com.dsagame.striver.atoz.arrays.easy;

public class MaxProductSubarray {
	public static void main(String[] args) {
		System.out.println(maxProduct(
				new int[] { 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0 }));

		System.out.println(maxProductSubArray(
				new int[] { 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0 }));

	}

	public static int maxProduct(int[] nums) {
		int res = Integer.MIN_VALUE;
		int prefix = 1, suffix = 1;
		for (int i = 0; i < nums.length; i++) {
			if (prefix == 0) {
				prefix = 1;
			}
			if (suffix == 0) {
				suffix = 1;
			}
			prefix *= nums[i];
			suffix *= nums[nums.length - i - 1];
			res = Math.max(res, Math.max(prefix, suffix));
			System.out.println(prefix + " eg" + suffix);
		}
		return res;
	}

	public static int maxProductSubArray(int[] arr) {
		int n = arr.length; // size of array.

		int pre = 1, suff = 1;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (pre == 0)
				pre = 1;
			if (suff == 0)
				suff = 1;
			pre *= arr[i];
			suff *= arr[n - i - 1];
			ans = Math.max(ans, Math.max(pre, suff));
		}
		return ans;
	}
}
