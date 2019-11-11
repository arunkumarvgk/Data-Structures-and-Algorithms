package com.ds.algo.array.arrangement;

public class DoubleFirstElemMoveZeroToEnd {

	static void rearrange(int arr[]) {
		int n = arr.length;
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				if (i < n - 1 && arr[i] == arr[i + 1]) {
					arr[i] = arr[i] * 2;
					arr[i + 1] = 0;
				}
				swap(arr, k, i);
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
		rearrange(new int[] { 2, 2, 0, 4, 0, 8 });
		rearrange(new int[] { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 });
	}

}
