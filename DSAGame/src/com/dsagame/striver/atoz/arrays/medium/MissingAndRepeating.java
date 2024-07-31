package com.dsagame.striver.atoz.arrays.medium;

import java.util.Arrays;

public class MissingAndRepeating {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findTwoElement(new int[] { 3, 1, 2, 5, 4, 6, 7, 5 }, 8)));
		// System.out.println(firstSetBit(40));
		System.out.println(Arrays.toString(findTwoElementXor(new int[] { 3, 1, 2, 5, 4, 6, 7, 5 }, 8)));
	}

	static int[] findTwoElement(int arr[], int n) {
		long expectedSum = n * (n + 1) / 2;
		long actualSum = Arrays.stream(arr).sum();
		long expectedSqSum = (n * (n + 1) * (2 * n + 1)) / 6;
		long actualSqSum = 0;
		for (int x : arr) {
			actualSqSum += (x * x);
		}
		long xMinusY = actualSum - expectedSum;
		long xPlusY = (actualSqSum - expectedSqSum) / (xMinusY);

		long repeated = (xPlusY + xMinusY) / 2;
		long missing = repeated - xMinusY;
		return new int[] { (int) repeated, (int) missing };
	}

	static int[] findTwoElementXor(int arr[], int n) {
		int xor = 0;
		for (int i = 0; i < n; i++) {
			xor ^= arr[i];
			xor ^= (i + 1);
		}
		int firstSetBit = firstSetBit(xor);
		int zeroClub = 0;
		int oneClub = 0;
		for (int i = 0; i < n; i++) {
			if (isKthSet(arr[i], firstSetBit)) {
				oneClub ^= arr[i];
			} else {
				zeroClub ^= arr[i];
			}
			if (isKthSet(i + 1, firstSetBit)) {
				oneClub ^= (i + 1);
			} else {
				zeroClub ^= (i + 1);
			}
		}
		int count = 0;
		for (int x : arr) {
			if (x == zeroClub) {
				count++;
			}
		}
		return count != 0 ? new int[] { zeroClub, oneClub } : new int[] { oneClub, zeroClub };
	}

	static int firstSetBit(int n) {
		int res = 0;
		while (n > 0) {
			if ((n & (1 << res)) != 0) {
				return res;
			}
			res++;
		}
		return res;
	}

	static boolean isKthSet(int n, int k) {
		return (n & (1 << k)) != 0;
	}

}
