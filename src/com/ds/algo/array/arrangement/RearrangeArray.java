package com.ds.algo.array.arrangement;

import java.util.Arrays;

public class RearrangeArray {

	private static void rearrange2(int arr[]) {
		int count = 0;
		for (int i = 0; i < arr.length;) {
			count++;
			if (arr[i] >= 0 && arr[i] != i) {
				int swapElem = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = swapElem;
			} else {
				i++;
			}
		}

		System.out.println("Count " + count);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void rearrange3(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] >= 0 && i != arr[i]) {
				int swapElem = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = swapElem;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void rearrange(int arr[]) {
		int n = arr.length;
		int tempArr[] = new int[n];
		Arrays.fill(tempArr, -1);

		for (int i = 0; i < n; i++) {
			if (arr[i] < 0 || arr[i] >= n) {
				continue;
			}
			tempArr[arr[i]] = arr[i];
		}

		for (int i = 0; i < n; i++) {
			System.out.print(tempArr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		rearrange3(new int[] { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 });
		rearrange3(new int[] { 19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4 });
		//rearrange2(new int[] { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 });
		//rearrange2(new int[] { 19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4 });
		//rearrange2(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
	}

}
