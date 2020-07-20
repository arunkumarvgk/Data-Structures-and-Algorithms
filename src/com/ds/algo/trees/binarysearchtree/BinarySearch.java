package com.ds.algo.trees.binarysearchtree;

public class BinarySearch {

	private int binarySearch(int low, int high, int key, int arr[]) {
		while (low <= high) {
			int mid = (low + high) / 2;

			int cur = arr[mid];
			if (key == cur) {
				return mid;
			}

			if (cur > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.binarySearch(0, 4, 1, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(bs.binarySearch(0, 4, 2, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(bs.binarySearch(0, 4, 3, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(bs.binarySearch(0, 4, 4, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(bs.binarySearch(0, 4, 5, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(bs.binarySearch(5, 4, 2, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(bs.binarySearch(0, 4, 12, new int[] { 1, 2, 3, 4, 5 }));
	}

}
