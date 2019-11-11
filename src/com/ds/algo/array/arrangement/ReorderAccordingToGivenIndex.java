package com.ds.algo.array.arrangement;

public class ReorderAccordingToGivenIndex {

	static void rearrange(int arr[], int index[]) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (index[i]!=i) {
				swap(arr, i, index[i]);
				swap(index, i, index[i]);
			}
			
		}

		for (int r = 0; r < n; r++) {
			System.out.print(arr[r] + " ");
		}
		System.out.print(">>>>>>>>>>>");
		for (int r = 0; r < n; r++) {
			System.out.print(index[r] + " ");
		}
		
		System.out.println();
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		rearrange(new int[] { 10, 11, 12 }, new int[] { 1, 0, 2 });
		rearrange(new int[] { 50, 40, 70, 60, 90 }, new int[] { 3, 0, 4, 1, 2 });

	}

}
