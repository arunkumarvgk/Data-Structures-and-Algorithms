package com.ds.algo.mainproblems;

import java.util.Arrays;

public class FindNumberOfPossibleTraingles {

	private static void find(int arr[]) {
		Arrays.sort(arr);
		int n = arr.length;
		int total = 0;
		for (int i = 0; i < n; i++) {
			int j = n - 1;
			while (i < j - 1) {
				int start = arr[i];
				int end = arr[j];
				int requiredMiddleValue = end - start;
				int noOfPossibilities = binarySerach(i + 1, j - 1, requiredMiddleValue, arr);
				total = total + noOfPossibilities;
				j--;
			}
		}

		System.out.println("Number of traingles is/are " + total);
	}

	private static int binarySerach(int l, int h, int requiredMiddleValue, int arr[]) {
		int m = 0;
		int s = l;
		int e = h;

		if (s == e) {
			return arr[s] > requiredMiddleValue ? 1 : 0;
		}

		while (s <= e) {
			m = (s + e) / 2;
			if (arr[m] < requiredMiddleValue) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		if (s > e) {
			m = m + 1;
		}
		
		if (arr[m] < requiredMiddleValue) {
			return 0;
		}

		return h - m + 1;
	}

	public static void main(String[] args) {
		find(new int[] { 4, 6, 3, 7 });
		find(new int[] { 10, 21, 22, 100, 101, 200, 300 });
	}

}
