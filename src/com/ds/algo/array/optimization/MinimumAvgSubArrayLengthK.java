package com.ds.algo.array.optimization;

public class MinimumAvgSubArrayLengthK {

	private static void find(int arr[], int k) {
		int n = arr.length;
		int sum = 0;
		int s = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		int avg = sum / k;
		for (int i = k; i < n; i++) {
			sum -= arr[i - k];
			sum += arr[i];

			if (avg > (sum / k)) {
				s = n - k - 1;
				avg = sum / k;
			}
		}

		System.out.println("Min avg " + avg + " is from index " + s + " to " + (s + k));
	}

	public static void main(String[] args) {
		find(new int[] { 1, 12, -5, -6, 50, 3 }, 4);
		find(new int[] { 3, 7, 90, 20, 10, 50, 40 }, 3);
		find(new int[] { 3, 7, 5, 20, -10, 0, 12 }, 2);
	}

}
