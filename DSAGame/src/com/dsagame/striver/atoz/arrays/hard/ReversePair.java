package com.dsagame.striver.atoz.arrays.hard;

public class ReversePair {
	public static void main(String[] args) {
		System.out.println(reversePairs(new int[] { 1, 3, 2, 3, 1 }));
		System.out.println(reversePairs(new int[] { 2, 4, 3, 5, 1 }));
	}

	public static int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	private static int mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return 0;
		}
		int mid = (low + high) / 2;
		return mergeSort(arr, low, mid) + mergeSort(arr, mid + 1, high) + merge(arr, low, mid, high);

	}

	private static int merge(int[] arr, int low, int mid, int high) {
		int[] resultArr = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0;
		int res = 0;
		int y = mid + 1;
		for (int x = low; x <= mid; x++) {
			while (y <= high && arr[x] > (2 * (long) arr[y])) {
				y++;
			}
			res += (y - mid - 1);
		}
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				resultArr[k++] = arr[i++];
			} else {
				resultArr[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			resultArr[k++] = arr[i++];
		}
		while (j <= high) {
			resultArr[k++] = arr[j++];
		}
		for (int x = low; x <= high; x++) {
			arr[x] = resultArr[x - low];
		}
		return res;
	}

}
