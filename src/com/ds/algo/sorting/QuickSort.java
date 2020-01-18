package com.ds.algo.sorting;

public class QuickSort {

	private static int partition(int arr[], int l, int h) {
		int i = l + 1;
		int piv = arr[l];

		for (int j = l + 1; j <= h; j++) {
			if (piv > arr[j]) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, l , i - 1);
		print(arr);
		return i - 1;
	}

	private static void quickSort(int arr[], int l, int h) {
		if (l < h) {
			int pivPos = partition(arr, l, h);
			quickSort(arr, l, pivPos - 1);
			quickSort(arr, pivPos + 1, h);
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void print(int arr[]) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 40, 80, 30, 90, 10, 50, 70 };
		int n = arr.length;
		print(arr);
		quickSort(arr, 0, n-1);
		print(arr);
	}

}
