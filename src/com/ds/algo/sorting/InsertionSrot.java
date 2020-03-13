package com.ds.algo.sorting;

public class InsertionSrot {
	private static void insertionSort(int arr[]) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			count++;

			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;

				count++;
			}
			arr[j + 1] = key;
		}

		System.out.println("No of iterations : " + count);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		insertionSort(new int[] { 5, 4, 3, 2, 1 });
		insertionSort(new int[] { 1, 2, 3, 4, 5 });
		insertionSort(new int[] { 3, 4, 5, 1, 2 });

	}

}
