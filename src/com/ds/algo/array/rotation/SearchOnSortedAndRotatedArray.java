package com.ds.algo.array.rotation;

public class SearchOnSortedAndRotatedArray {

	private static int pivotedinarySearch(int arr[], int n, int key) {
		//Find where the sorting is broken
		int pivot = findPivot(arr, 0, n - 1);

		if (pivot == -1) {
			return binarySearch(arr, 0, n - 1, key);
		}

		if (arr[pivot] == key) {
			return pivot;
		}

		if (arr[0] <= key) {
			return binarySearch(arr, 0, pivot - 1, key);
		} else {
			return binarySearch(arr, pivot + 1, n - 1, key);
		}
	}

	private static int binarySearch(int[] arr, int i, int j, int key) {
		if (j < i) {
			return -1;
		}

		int m = (i + j) / 2;
		if (key == arr[m]) {
			return m;
		}

		if (key > arr[m]) {
			return binarySearch(arr, m + 1, j, key);
		} else {
			return binarySearch(arr, i, m - 1, key);
		}
	}

	private static int findPivot(int[] arr, int i, int j) {
		if (i > j) {
			return -1;
		}

		if (i == j) {
			return i;
		}

		int m = (i + j) / 2;

		if (arr[m] > arr[m + 1]) {
			return m;
		} else if (arr[m] < arr[m - 1]) {
			return m - 1;
		}

		if (arr[i] >= arr[m]) {
			return findPivot(arr, i, m - 1);
		} else {
			return findPivot(arr, m + 1, j);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5 };
		int key = 4;
		System.out.println(pivotedinarySearch(arr, arr.length, key));
	}
}
