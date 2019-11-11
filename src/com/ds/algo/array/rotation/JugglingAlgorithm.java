package com.ds.algo.array.rotation;

public class JugglingAlgorithm {

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private static void rotate(int arr[], int shiftBy) {
		int length = arr.length;
		int gcd = gcd(length, shiftBy);

		for (int i = 0; i < gcd; i++) {
			int temp = arr[i];
			int j = i;
			while (true) {
				int k = j + shiftBy;
				if (k >= length) {
					k = k - length;
				}
				if (k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int shiftBy = 5;
		rotate(arr, shiftBy);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
