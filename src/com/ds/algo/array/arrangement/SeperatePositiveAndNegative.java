package com.ds.algo.array.arrangement;

public class SeperatePositiveAndNegative {
	static void rearrange(int arr[]) {
		int n = arr.length;
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				swap(arr, i, k);
				k++;
			}
		}

		for (int r = 0; r < n; r++) {
			System.out.print(arr[r] + " ");
		}
		System.out.println();
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		rearrange(new int[] { 12, 11, -13, -5, 6, -7, 5, -3, -6 });
		rearrange(new int[] { -12, 11, -13, -5, 6, -7, 5, -3, -6 });
	}

}
