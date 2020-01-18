package com.ds.algo.array.arrangement;

public class SmallerEvenIndexAndBiggerOddIndex {

	private static void rearrange(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			if (i % 2 == 0 && arr[i] > arr[i + 1]) {
				swap(arr, i, i+1);
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 3, 5, 1 };
		rearrange(arr);
	}

}
