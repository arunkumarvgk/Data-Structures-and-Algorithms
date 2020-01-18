package com.ds.algo.array.optimization;

public class MaximumSubArraySlidingWindow {

	private static void findMax(int arr[], int k) {
		int sum = 0;
		int max = 0;

		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		for (int i = k; i < arr.length; i++) {
			sum = sum - arr[i - k];
			sum = sum + arr[i];
			if (sum > max) {
				max = sum;
			}
		}

		System.out.println("Max Is ::" + max);
	}

	private static void findMin(int arr[], int k) {
		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		for (int i = k; i < arr.length; i++) {
			sum = sum - arr[i - k];
			sum = sum + arr[i];
			if (sum < min) {
				min = sum;
			}
		}

		System.out.println("Min Is ::" + min);
	}

	public static void main(String[] args) {
		findMax(new int[] { 3, 7, 90, 20, 10, 50, 40 }, 3);
		findMin(new int[] { 3, 7, 90, 20, 10, 50, 40 }, 3);
		findMin(new int[] { 3, 7, 5, 20, -10, 0, 12 }, 2);
	}

}
