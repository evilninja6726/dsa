package com.dsagame.sheet.striver.binarysearch.medium;

public class MinInRotatedSorted {
	public static void main(String[] args) {

	}

	public int findMin(int[] arr) {
		int i = 0, j = arr.length - 1, res = Integer.MAX_VALUE;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (arr[i] <= arr[mid]) {
				res = Math.min(res, arr[i]);
				i = mid + 1;
			} else {
				res = Math.min(res, arr[mid]);
				j = mid - 1;
			}
		}
		return res;
	}
}
