package com.ds.algo.algorithms;

public class SlidingWindowTechnique {

	private static void find(int arr[], int k) {
		int n = arr.length;

		int msum = 0;
		for (int i = 0; i <= (n - k); i++) {
			int wsum = 0;
			for (int j = i; j < (k + i); j++) {
				wsum += arr[j];
			}
			if (wsum > msum) {
				msum = wsum;
			}
		}

		System.out.println("Max Sum " + msum);
	}

	private static void find2(int arr[], int k) {
		int n = arr.length;
		int ws = 0;
		int ms = 0;
		
		for (int i = 0; i < k; i++) {
			ws+=arr[i];
		}
		
		for (int i = 0; i < (n-k); i++) {
			ws = ws - arr[i] + arr[k+i];
			
			if (ws > ms) {
				ms = ws;
			}
		}
		
		System.out.println("Max Sum "+ ms);
	}

	/*
	 * For finding maximum sum of contiguous sub array of size k
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 9, -1, -2, 7, 3, -1, 2 };
		int k = 5;
		for (int i = 1; i <= k; i++) {
			find(arr, i);
			find2(arr, i);
		}
		
	}

}
