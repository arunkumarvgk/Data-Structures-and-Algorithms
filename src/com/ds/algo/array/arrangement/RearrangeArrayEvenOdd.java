package com.ds.algo.array.arrangement;

import java.util.Arrays;

public class RearrangeArrayEvenOdd {

	// Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if
	// i is odd and j < i

	private static void rearrange(int arr[]) {
		Arrays.sort(arr);
		int length = arr.length;
		int temp[] = new int[length];
		int n = (int) Math.ceil(length / 2) - 1;
		int m = length / 2;
		for (int i = 0; i < length; i++) {
			temp[i] = arr[n--];
			if (m != length) {
				temp[++i] = arr[m++];
			}
		}

		for (int i = 0; i < length; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

	private static void rearrange2(int arr[]) {
		Arrays.sort(arr);
		int length = arr.length;
		int evenPos = length / 2;
		int oddPos = length - evenPos;
		int j = oddPos - 1;
		int temp[] = new int[length];

		for (int i = 0; i < length; i = i + 2) {
			temp[i] = arr[j--];
			if (i != length - 1) {
				temp[i + 1] = arr[oddPos++];
			}
		}

		for (int i = 0; i < length; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		rearrange2(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		rearrange2(new int[] { 1, 2, 1, 4, 5, 6, 8, 8 });
	}
}
