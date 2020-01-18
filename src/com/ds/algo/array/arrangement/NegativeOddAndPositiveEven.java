package com.ds.algo.array.arrangement;

public class NegativeOddAndPositiveEven {

	private static void rearrange(int[] arr) {
		int n = arr.length;
		int pos = 0;
		int neg = 1;
		while (true) {
			while (pos < n && arr[pos] > 0) {
				pos += 2;
			}

			while (neg < n && arr[neg] < 0) {
				neg += 2;
			}

			if (pos < n && neg < n) {
				swap(arr, pos, neg);
			} else {
				break;
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
		int arr[] = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10}; 
		rearrange(arr);
	}

}
