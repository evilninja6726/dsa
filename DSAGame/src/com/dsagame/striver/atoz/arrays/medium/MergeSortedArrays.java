package com.dsagame.striver.atoz.arrays.medium;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if ((m == 0 && n == 0) || n == 0) {
			return;
		} else if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
		int i = 0, j = 0, k = m;
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				nums1[k++ % (m + n)] = nums1[i++];
			} else {
				nums1[k++ % (m + n)] = nums2[j++];
			}
		}
		while (i < m) {
			nums1[k++ % (m + n)] = nums1[i++];
		}
		while (j < n) {
			nums1[k++ % (m + n)] = nums2[j++];
		}
		System.out.println(Arrays.toString(nums1));
		rotate(nums1, n);
		System.out.println(Arrays.toString(nums1));
	}

	public static void rotate(int[] arr, int k) {
		reverse(arr, 0, arr.length - k - 1);
		reverse(arr, arr.length - k, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	public static void reverse(int[] arr, int i, int j) {
		while (i < j) {
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i++] ^= arr[j--];
		}
	}
}
