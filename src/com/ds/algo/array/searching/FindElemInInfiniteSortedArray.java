package com.ds.algo.array.searching;

public class FindElemInInfiniteSortedArray {

	private static void find(int arr[], int k) {
		int l = 0;
		int h = 1;
		while (arr[h] < k) {
			l = h;
			h = 2 * h;
		}
		System.out.println(binarySearch(l, h, k, arr));
	}

	private static int binarySearch(int l, int h, int k, int[] arr) {
		while (l <= h) {
			int m = (l + h) / 2;

			if (arr[m] == k) {
				return m;
			}
			
			if (arr[m] > k) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		find(arr, 10);
	}

}
