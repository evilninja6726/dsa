package com.dsagame.sheet.striver.binarysearch.easy;

public class LowerBound {
	public static void main(String[] args) {
		System.out.println(findFloor(new long[] { 1, 2, 8, 10, 11, 12, 19 }, 7, 0));
	}

	static int findFloor(long arr[], int n, long x) {
		int i = 0, j = n - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] < x) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return j;
	}
}
