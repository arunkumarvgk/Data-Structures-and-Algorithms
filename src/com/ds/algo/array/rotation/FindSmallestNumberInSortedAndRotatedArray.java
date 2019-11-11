package com.ds.algo.array.rotation;

public class FindSmallestNumberInSortedAndRotatedArray {

	private static void findSmallest(int arr[], int n) {
		System.out.println(binarySearch(arr, 0, n));
	}

	private static int binarySearch(int[] arr, int low, int high) {

		if (low > high) {
			return arr[0];
		}

		if (low == high) {
			return arr[low];
		}

		int mid = low + (high - low) / 2;

		//if completed rotated
		if (low < mid && high > mid && arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
			return arr[high];
		}
		
		if (low < mid && arr[mid] < arr[mid - 1]) {
			return arr[mid];
		}

		if (high > mid && arr[mid] > arr[mid + 1]) {
			return arr[mid + 1];
		}

		if (arr[low] > arr[mid]) {
			return binarySearch(arr, low, mid - 1);
		} else if (arr[high] < arr[mid]) {
			return binarySearch(arr, mid + 1, high);
		} else {
			//if not rotated
			return arr[0];
		}
	}

	public static void main(String[] args) {
		findSmallest(new int[] { 7, 9, 1, 2, 3, 4, 6 }, 6);
		findSmallest(new int[] { 7, 1, 2, 3, 4, 6 }, 5);
		findSmallest(new int[] { 0, 1, 2, 3, 4, 6 }, 5);
		findSmallest(new int[] { 7, 9, 1, 2 }, 3);
		findSmallest(new int[] { 7, 9, 2, 1, 0 }, 4);
	}

}
