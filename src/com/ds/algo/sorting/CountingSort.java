package com.ds.algo.sorting;

public class CountingSort {

	private static void countingSort(int arr[]) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		int aux[] = new int[max+1];

		for (int i = 0; i < arr.length; i++) {
			aux[arr[i]]++;
		}

		int j = 0;
		for (int i = 0; i < aux.length; i++) {
			if (aux[i] > 0) {
				int temp = aux[i];
				while (temp-- != 0) {
					arr[j++] = i;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		countingSort(new int[] { 4, 2, 2, 8, 3, 3, 1 });
	}

}
