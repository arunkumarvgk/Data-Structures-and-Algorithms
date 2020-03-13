package com.ds.algo.array.optimization;

import java.util.Arrays;

public class MinNumberOfJumpsToReachEnd {

	private static void find(int arr[]) {
		int n = arr.length;
		int i = 0;
		int count = 0;
		int j = 0;
		boolean cannotReach = false;
		while (true) {
			if (arr[i] + i <= n - 1) {
				count++;
				j = i;
				i = i + arr[i];
				continue;
			} else {
				if (j < i) {
					i--;
					continue;
				}
				cannotReach = true;
				break;
			}
		}
		if (cannotReach) {
			System.out.println("Cannot Reach destination");
		} else {
			System.out.println("Max Steps " + count);
		}
	}

	private static void find2(int arr[]) {
		int n = arr.length;
		int temp[] = new int[n];
		Arrays.fill(temp, Integer.MAX_VALUE);
		temp[0] = 0;

		for (int i = 0; i < n; i++) {
			int to = i + arr[i] > n - 1 ? n - 1 : i + arr[i];
			int steps = temp[i] + 1;

			for (int j = i + 1; j <= to; j++) {
				if (temp[j] > steps) {
					temp[j] = steps;
				}
			}
		}

		System.out.println("Max Steps " + temp[n - 1]);
		for (int i = 0; i < n; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		find2(new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 });
		find2(new int[] { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 });
		find2(new int[]{ 1, 3, 6, 1, 0, 9 });
	}

}
