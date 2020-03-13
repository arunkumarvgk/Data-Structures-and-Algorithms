package com.ds.algo.array.rotation;

public class BlockSwapAlgorithm {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 3;
		//rotate(arr, d, arr.length);
		//print(arr);
		System.out.println();
		int arrs[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateRight(arrs, d, arr.length);
		print(arrs);
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	private static void rotate(int[] arr, int d, int n) {
		int a = d;
		int b = n - d;

		if (d == 0 || d == n) {
			return;
		}

		if (d == n - d) {
			swap(arr, 0, n - d, d);
			return;
		}

		while (a != b) {
			if (a < b) {
				swap(arr, d - a, d + b - a, a);
				b = b - a;
			} else {
				swap(arr, d - a, d, b);
				a = a - b;
			}
		}
		swap(arr, d - a, d, a);
	}

	private static void rotateRight(int[] arr, int d, int n) {
		int a = d;
		int b = n - d;

		if (d == 0 || d == n) {
			return;
		}

		if (d == n - d) {
			swap(arr, 0, n - d, d);
			return;
		}

		while (a != b) {
			if (a < b) {
				swap(arr, n - (d + b), n - a, a);
				b = b - a;
			} else {
				swap(arr, n - (d + b) , n - b, b);
				a = a - b;
			}
		}
		swap(arr, d + a , n - a, a);
	}
	
	private static void swap(int[] arr, int a, int b, int d) {
		for (int k = 0; k < d; k++) {
			int temp = arr[a + k];
			arr[a + k] = arr[b + k];
			arr[b + k] = temp;
		}
	}

}
