package com.ds.algo.array.searching;

public class FindPeakElement {

	private static void findPeak(int arr[]) {
		int n = arr.length;
		int index = binarySearch(0, n - 1, arr, n);
		System.out.println(arr[index]);
	}

	private static int binarySearch(int l, int h, int[] arr, int n) {
		int m = (l + h) / 2;
		if ((m == 0 || arr[m] >= arr[m - 1]) && (m == n - 1 || arr[m] >= arr[m + 1])) {
			return m;
		} else if (m > 0 && arr[m - 1] > arr[m]) {
			return binarySearch(l, m - 1, arr, n);
		} else {
			return binarySearch(m + 1, h, arr, n);
		}
	}

	public static void main(String[] args) {
		findPeak(new int[] { 1, 3, 20, 4, 1, 0 });
		findPeak(new int[] { 1, 21, 20, 4, 1, 0 });
	}

}
