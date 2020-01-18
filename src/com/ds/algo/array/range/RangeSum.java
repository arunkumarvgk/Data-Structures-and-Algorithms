package com.ds.algo.array.range;

public class RangeSum {

	private static void prefixSum(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
	}

	private static void range(int arr[], int from, int to) {
		int n = arr.length;
		if (from <= to && from < n && to < n) {
			if (from == 0 || from == to) {
				System.out.println(arr[to]);
			} else {
				System.out.println(arr[to] - arr[from - 1]);
			}
		}

	}

	public static void main(String[] args) {
		
		int arr[] = { 1, 1, 2, 1, 3, 4, 5, 2, 8 };
		int arr2[] = { 1, 5, 2, 4, 6, 1, 3, 5, 7, 10 };
		int arr3[] = {7, 2, 3, 0, 5, 10, 3, 12, 18}; 
		prefixSum(arr);
		range(arr, 1, 3);
		range(arr, 0, 4);
		range(arr, 2, 4);
		
		System.out.println("_______________");
		prefixSum(arr2);
		range(arr2, 3, 8);
		range(arr2, 1, 6);
		range(arr2, 8, 8);
		
		System.out.println("_______________");
		prefixSum(arr3);
		range(arr3, 0, 4);
		range(arr3, 4, 7);
		range(arr3, 7, 8);
	}

}
