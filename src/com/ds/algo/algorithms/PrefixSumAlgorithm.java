package com.ds.algo.algorithms;

public class PrefixSumAlgorithm {

	private static void prefixSum(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i] + arr[i - 1];
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		prefixSum(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 });
	}

}
