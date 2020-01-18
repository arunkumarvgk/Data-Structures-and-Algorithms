package com.ds.algo.array.optimization;

import java.util.Arrays;

public class MinTheMaxDiffBtwHeights {

	private static void find(int arr[], int k) {
		int n = arr.length;
		Arrays.sort(arr);

		int min = arr[n - 1] - arr[0];
		int big = arr[n - 1] - k;
		int small = arr[0] + k;

		for (int i = 1; i < arr.length - 1; i++) {
			int sub = arr[i] - k;
			int add = arr[i] + k;

			if (add <= big) {
				continue;
			}

			if (sub >= small) {
				continue;
			}

			if (big - sub <= add - small) {
				small = sub;
			} else {
				big = add;
			}
		}

		System.out.println("Min :: " + Math.min(min, Math.abs(big - small)));
	}

	public static void main(String[] args) {
		find(new int[] { 1, 15, 10 }, 3);
		find(new int[] { 1, 10, 14, 14, 14, 15 }, 6);
	}

}
