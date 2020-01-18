package com.ds.algo.array.arrangement;

public class SeperateEvenAndOdd {

	private static void rearrange(int arr[]) {
		int n = arr.length;
		int i = -1;
		int j = 0;

		while (j != n) {
			if (arr[j]%2 ==0) {
				i++;
				swap(arr, i, j);
			}
			j++;
		}
		
		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
		rearrange(arr);
	}

}
