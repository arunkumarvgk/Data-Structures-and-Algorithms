package com.ds.algo.bitwisealgorithms;

public class CountNoOf1sFrom1toN {

	private static void calculate(int n) {
		int arr[] = new int[n + 1];

		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= n; i++) {

			if (i % 2 == 0) {
				arr[i] = arr[i / 2];
			} else {
				arr[i] = arr[i - 1] + 1;
			}
		}
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += arr[i];
		}

		System.out.println(n + " -> " + sum);
	}

	public static void main(String[] args) {
		calculate(10);
	}

}
