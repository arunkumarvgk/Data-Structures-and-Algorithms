package com.ds.algo.array.searching;

public class PrintLeaders {

	private static void print(int arr[]) {
		int n = arr.length;
		int max = arr[n - 1];
		System.out.print(arr[n - 1] + " ");
		for (int i = n - 2; i >= 0; i--) {
			if (max < arr[i]) {
				max = arr[i];
				System.out.print(arr[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		print(new int[] { 16, 17, 4, 3, 5, 2 });
	}

}
