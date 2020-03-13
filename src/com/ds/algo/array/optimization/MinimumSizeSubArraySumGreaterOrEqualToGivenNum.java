package com.ds.algo.array.optimization;

public class MinimumSizeSubArraySumGreaterOrEqualToGivenNum {

	private static void find(int arr[], int k) {
		int start = 0;
		int minLen = Integer.MAX_VALUE;

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			while (sum > k) {
				minLen = Math.min(minLen, i + 1 - start);
				sum = sum - arr[start];
				start++;
			}
		}

		System.out.println("Minimum length is :: " + ((minLen != Integer.MAX_VALUE) ? minLen : -1));
	}

	public static void main(String[] args) {
		find(new int[] { 2, 3, 1, 2, 4, 3, 7 }, 7);
		find(new int[] { 1 }, 1);
		find(new int[] { 1, 2 }, 4);
		find(new int[] { 2, -1, 2 }, 3);
		find(new int[] { 2, -1, 4, 2 }, 5);
		find(new int[] { 1, 4, 45, 6, 0, 19 }, 51);
		find(new int[] { 1, 10, 5, 2, 7 }, 9);
		find(new int[] { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 }, 280);
		find(new int[] { 1, 2, 4 }, 8);
		find(new int[] { 1, 1, 1, 1, 2, 1, 3 }, 4);
	}
}
