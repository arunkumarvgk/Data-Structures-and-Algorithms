package com.ds.algo.array.rotation;

public class PrintArrayRotationsQuickly {

	private static void printRotated(int arr[], int n, int k) {
		for (int i = k; i < k + n; i++) {
			System.out.print(arr[i % n] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		printRotated(new int[] { 1, 2, 3, 4, 5 }, 5, 0);
		printRotated(new int[] { 1, 2, 3, 4, 5 }, 5, 1);
		printRotated(new int[] { 1, 2, 3, 4, 5 }, 5, 2);
		printRotated(new int[] { 1, 2, 3, 4, 5 }, 5, 3);
		printRotated(new int[] { 1, 2, 3, 4, 5 }, 5, 4);
		printRotated(new int[] { 1, 2, 3, 4, 5 }, 5, 5);
		printRotated(new int[] { 1, 2, 3, 4, 5 }, 5, 6);
	}

}
