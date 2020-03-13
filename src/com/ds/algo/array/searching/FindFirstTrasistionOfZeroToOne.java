package com.ds.algo.array.searching;

public class FindFirstTrasistionOfZeroToOne {

	private static int binarySearch(int l, int h, int arr[]) {
		while (l <= h) {
			int m = (l + h) / 2;
			if (arr[m] == 1 && (m == 0 || arr[m - 1] == 0)) {
				return m;
			} else if (arr[m] == 0) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
		System.out.println(binarySearch(0, arr.length - 1, arr));
		arr = new int[] { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(binarySearch(0, arr.length - 1, arr));
		arr = new int[] { 0, 1 };
		System.out.println(binarySearch(0, arr.length - 1, arr));
		arr = new int[] { 1 };
		System.out.println(binarySearch(0, arr.length - 1, arr));
	}

}
