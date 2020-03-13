package com.ds.algo.array.sorting;

public class MinimumNumberOfSwapToSortArray {

	private static void sort(int arr[]) {
		int n = arr.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				swap(arr, i, arr[i] - 1);
				count++;
				continue;
			}
		}
		System.out.println("Minimum number of swaps :: " + count);
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	private static void minSwaps(int arr[]) {
		int swaps = 0;
		boolean[] visited = new boolean[ arr.length];

		for (int i = 0; i < arr.length; i++) {
			int j = i;
			int cycles = 0;

			while (!visited[j]) {
				visited[j] = true;
				j = arr[j] - 1;
				cycles++;
			}

			if (cycles != 0) {
				swaps = swaps + cycles - 1;
			}
		}

		System.out.println("Minimum number of swaps :: " + swaps);
	}

	static void minimumSwaps(int[] arr) {
		int swap = 0;
		boolean visited[] = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int j = i, cycle = 0;

			while (!visited[j]) {
				visited[j] = true;
				j = arr[j] - 1;
				cycle++;
			}

			if (cycle != 0)
				swap += cycle - 1;
		}
		System.out.println("Minimum number of swaps :: " + swap);
	}

	public static void main(String[] args) {
		minSwaps(new int[] { 2, 4, 5, 1, 3 });
		minSwaps(new int[] { 1, 5, 4, 3, 2 });
		minSwaps(new int[] { 4, 3, 1, 2 });
	}

}
