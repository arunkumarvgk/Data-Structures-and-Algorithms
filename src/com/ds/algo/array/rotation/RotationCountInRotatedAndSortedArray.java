package com.ds.algo.array.rotation;

public class RotationCountInRotatedAndSortedArray {

	public static void main(String[] args) {
		int arr[] = { 15, 18, 2, 3, 7, 12 };
		int arr2[] = { 7, 9, 11, 12, 5 };
		
		System.out.println(findUsingBinarySearch(arr, 0, arr.length - 1));
		System.out.println(find(arr, 0, arr.length - 1) + 1);
		
		System.out.println(findUsingBinarySearch(arr2, 0, arr.length - 1));
		System.out.println(find(arr2, 0, arr.length - 1) + 1);
	}

	private static int find(int[] arr, int l, int h) {
		int m = (l + h) / 2;

		if (arr[m] < arr[m - 1]) {
			return m - 1;
		}

		if (arr[m] > arr[m + 1]) {
			return m;
		}

		if (arr[l] < arr[m]) {
			return find(arr, m + 1, h);
		} else {
			return find(arr, l, m - 1);
		}
	}

	private static int findUsingBinarySearch(int[] arr, int low, int high) {

		if (high < low)
			return 0;

		// If there is only one element left
		if (high == low)
			return low;

		int mid = (low + high) / 2;

		if (mid > low && arr[mid] < arr[mid - 1]) {
			return mid;
		}

		if (mid < high && arr[mid] > arr[mid + 1]) {
			return mid + 1;
		}

		if (arr[low] > arr[mid]) {
			return findUsingBinarySearch(arr, low, mid - 1);
		} else {
			return findUsingBinarySearch(arr, mid + 1, high);
		}

	}

}
