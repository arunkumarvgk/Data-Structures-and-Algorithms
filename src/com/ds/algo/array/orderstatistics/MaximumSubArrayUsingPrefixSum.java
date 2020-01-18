package com.ds.algo.array.orderstatistics;

public class MaximumSubArrayUsingPrefixSum {

	private static void prefixSum(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i] + arr[i - 1];
		}
	}

	private static void maxSum(int arr[]) {
		prefixSum(arr);
		int maxSum = arr[0];
		int minPrefix = arr[0];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = arr[i] - minPrefix;

			if (maxSum < sum) {
				maxSum = sum;
			}

			if (arr[i] < minPrefix) {
				minPrefix = arr[i];
			}
		}

		System.out.println("Max Sum is " + maxSum);
	}

	public static void main(String[] args) {
		int arr1[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int arr2[] = { 4, -8, 9, -4, 1, -8, -1, 6 };
		
		maxSum(arr1);
		maxSum(arr2);
	}

}
