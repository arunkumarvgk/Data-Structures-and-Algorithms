package com.ds.algo.sorting;

public class BubbleSort {
	private static void bubbleSort(int arr[]) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count++;
			for (int j = i + 1; j < arr.length; j++) {
				count++;
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("No of iterations : " + count);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void bubbleSort2(int arr[], int k) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (Math.abs(arr[i] - k) > Math.abs(arr[j] - k)) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		bubbleSort(new int[] { 5, 1, 4, 2, 8 });
		bubbleSort(new int[] { 5, 4, 3, 2, 1 });
		bubbleSort(new int[] { 1, 2, 3, 4, 5 });
		bubbleSort(new int[] { 3, 4, 5, 1, 2 });
		bubbleSort2(new int[] { 10, 5, 3, 9, 2 }, 7);
	}
}
