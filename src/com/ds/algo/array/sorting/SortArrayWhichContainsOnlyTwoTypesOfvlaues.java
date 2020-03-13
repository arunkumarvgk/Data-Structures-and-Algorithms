package com.ds.algo.array.sorting;

public class SortArrayWhichContainsOnlyTwoTypesOfvlaues {

	private static void sort(int arr[]) {
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			while (arr[i] == 0 && i < j) {
				i++;
			}

			while (arr[j] == 1 && i < j) {
				j--;
			}

			swap(arr, i, j);
		}

		for (i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(	);
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		sort(new int[] { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 });
		sort(new int[] { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1 });
	}

}
