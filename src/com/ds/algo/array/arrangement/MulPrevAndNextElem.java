package com.ds.algo.array.arrangement;

public class MulPrevAndNextElem {

	private static void rearrange(int[] arr) {
		int n = arr.length;
		int temp = arr[0];
		arr[0] = arr[0] * arr[1];
		for (int i = 1; i < n - 1; i++) {
			int cur = arr[i];
			arr[i] = temp * arr[i + 1];
			temp = cur;
		}

		arr[n - 1] = arr[n - 1] * temp;

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5, 6 };
		rearrange(arr);
	}

}
