package com.dsagame.striver.atoz.arrays.medium;

public class CountInversions {
	public static void main(String[] args) {
		System.out.println(inversionCount(new long[] { 2, 4, 1, 3, 5 }, 5));
	}

	static long inversionCount(long arr[], int n) {
		return mergeSort(arr, 0, n - 1);
	}

	static long mergeSort(long[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		int mid = (i + j) / 2;
		return mergeSort(arr, i, mid) + mergeSort(arr, mid + 1, j) + merge(arr, i, mid, j);
	}

	static long merge(long[] arr, int i, int m, int j) {
		long res = 0;
		int left = i;
		int right = m + 1;
		int k = 0;
		long[] resultArr = new long[j - i + 1];
		while (left <= m && right <= j) {
			if (arr[left] > arr[right]) {
				res += (m - left + 1);
				resultArr[k++] = arr[right++];
			} else {
				resultArr[k++] = arr[left++];
			}
		}
		while (left <= m) {
			resultArr[k++] = arr[left++];
		}
		while (right <= j) {
			resultArr[k++] = arr[right++];
		}
		for (int x = i; x <= j; x++) {
			arr[x] = resultArr[x - i];
		}
		return res;
	}
}
