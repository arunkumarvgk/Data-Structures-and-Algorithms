package com.ds.algo.array.rotation;


//Time Complexity o(n)
public class ReversalAlgorithm {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int r = 5;
		rotate(arr, r);
		print(arr);

	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void rotate(int[] arr, int r) {
		reverse(arr, 0, r - 1);
		reverse(arr, r, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	private static void reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[end];
			arr[end--] = arr[start];
			arr[start++] = temp;
		}
	}

}
